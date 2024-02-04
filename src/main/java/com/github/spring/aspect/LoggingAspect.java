package com.github.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

import com.github.spring.aspect.annotation.LogEntryExit;
import com.github.spring.aspect.annotation.LogExceptions;
import com.github.spring.aspect.annotation.LogExecutionTime;
import com.github.spring.aspect.annotation.LogExternalService;
import com.github.spring.aspect.annotation.NoLog;

/**
 *
 * Aspect for logging entry and exit of methods, handling exceptions, and
 * measuring execution time.
 * 
 */
@Aspect
@Configuration
public class LoggingAspect {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Value("${logging.exceptionHandling.level:message_only}")
	private String exceptionLoggingMode;

	/**
	 * Pointcut to exclude methods or classes in specified packages and annotated
	 * with {@link NoLog}}.
	 */
	@Pointcut("@within(com.github.spring.aspect.annotation.NoLog) || @annotation(com.github.spring.aspect.annotation.NoLog)")
	public void noLogPointcut() {
		// define packages or classes in pointcut to to exclude logs
	}
	
	/**
	 * Pointcut to exclude methods or classes in specified packages and annotated
	 * with {@link LogExternalService}}.
	 */
	@Pointcut("@within(com.github.spring.aspect.annotation.LogExternalService) || @annotation(com.github.spring.aspect.annotation.LogExternalService)")
	public void externalServicePointcut() {
		// define packages or classes in pointcut to have external service call logs
	}

	/**
	 * Pointcut for logging entry and exit of methods or classes in specified
	 * packages and are annotated with {@link LogEntryExit}.
	 */
	@Pointcut("within(com...controller..*) || @annotation(com.github.spring.aspect.annotation.LogEntryExit) || @within(com.github.spring.aspect.annotation.LogEntryExit)")
	@ConditionalOnProperty(prefix = "logging.logEntryExit", name = "enabled", havingValue = "true", matchIfMissing = false)
	public void entryAndExitPointcut() {
		// define packages or classes in pointcut to have entry and exit logs
	}

	/**
	 * Pointcut for handling exceptions in specified packages and are annotated with
	 * {@link LogExceptions}.
	 */
	@Pointcut("within(com..service..*) || within(com..util..*) || within(com..utils..*) || within(com..restcontroller..*) ||"
			+ " within(com..repository..*) || within(com..controller..*) || within(com..rest..*) ||"
			+ " @annotation(com.github.spring.aspect.annotation.LogExceptions) || @within(com.github.spring.aspect.annotation.LogExceptions)")
	@ConditionalOnProperty(prefix = "logging.logExceptions", name = "enabled", havingValue = "true", matchIfMissing = false)
	public void exceptionsPointcut() {
		// define packages or classes in pointcut to have exception logs
	}

	/**
	 * Pointcut for measuring execution time of methods in specified packages and
	 * are annotated with {@link LogExecutionTime}.
	 */
	@Pointcut("within(com..controller..*) || @annotation(com.github.spring.aspect.annotation.LogExecutionTime) || @within(com.github.spring.aspect.annotation.LogExecutionTime)")
	@ConditionalOnProperty(prefix = "logging.logExecutionTime", name = "enabled", havingValue = "true", matchIfMissing = false)
	public void executionTimePointcut() {
		// define packages or classes in pointcut to have execution time logs
	}

	/**
	 * Advice to log entry and exit of methods.
	 *
	 * @param proceedingJoinPoint The proceeding join point for the advised method.
	 * @return The result of the advised method.
	 * @throws Throwable If an exception occurs during method execution.
	 */
	@Around(value = "entryAndExitPointcut() && !noLogPointcut() ")
	public Object logEntryAndExit(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();

		log.info("Entered Into {}.{}", className, methodName);
		Object result = proceedingJoinPoint.proceed();
		log.info("Exited from {}.{}", className, methodName);

		return result;
	}

	/**
	 * Advice to log exceptions thrown from methods.
	 *
	 * @param joinPoint The join point for the advised method.
	 * @param e         The thrown exception.
	 * @throws Throwable If an exception occurs during the handling of the original
	 *                   exception.
	 */
	// @AfterThrowing(pointcut = "@annotation(LogExceptions)", throwing = "e")
	@AfterThrowing(value = "exceptionsPointcut() && !noLogPointcut() ", throwing = "e")
	public void logExceptions(JoinPoint joinPoint, Throwable e) {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();

		switch (exceptionLoggingMode.toLowerCase()) {
		case "none":
			// No logging
			break;
		case "message_only":
			log.error("Exception has been thrown from {}.{} , message: {}", className, methodName, e.getMessage());
			break;
		case "stacktrace":
			log.error("Exception has been thrown from {}.{} , message:: {} , with stack trace:: {}", className,
					methodName, e.getMessage(), e);
			break;
		default:
			// No logging
		}
	}

	/**
	 * Advice to log execution time of methods.
	 *
	 * @param proceedingJoinPoint The proceeding join point for the advised method.
	 * @return The result of the advised method.
	 * @throws Throwable If an exception occurs during method execution.
	 */
	// @Around("@annotation(LogExecutionTime)")
	@Around(value = "executionTimePointcut() && !noLogPointcut()")
	public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();

		final StopWatch stopWatch = new StopWatch();

		stopWatch.start();
		Object result = proceedingJoinPoint.proceed();
		stopWatch.stop();

		log.info("Execution time of {}.{} :: {} ms", className, methodName, stopWatch.getTotalTimeMillis());

		return result;
	}
	
	/**
	 * Advice to log external service calls.
	 *
	 * @param proceedingJoinPoint The proceeding join point for the advised method.
	 * @return The result of the advised method.
	 */
	@Around(value = "externalServicePointcut() && !noLogPointcut()")
    public Object logExternalService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        log.info("External service call to {} took {} ms", proceedingJoinPoint.getSignature(), (endTime - startTime));
        return result;
    }

}

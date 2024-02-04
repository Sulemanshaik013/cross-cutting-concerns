package com.github.spring.aspect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.github.spring.aspect.ErrorHandlingAspect;
import com.github.spring.aspect.LoggingAspect;

/**
 * Annotation to mark methods for logging external service calls. Methods
 * annotated with {@code @LogExternalService} will have their external service
 * calls logged by the {@link LoggingAspect}.
 *
 * <p>
 * Example usage:
 * 
 * <pre>{@code
 * import com.github.spring.aspect.annotation.LogExternalService;
 *
 * {@literal @}LogExternalService
 * public void myMethod() {
 *     // Method implementation
 * }
 * }</pre>
 *
 * @see LoggingAspect
 * @see ErrorHandlingAspect
 * @see LogEntryExit
 * @see LogExecutionTime
 * @see LogExternalExceptions
 * @see LogExceptions
 * @see NoLog
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE, ElementType.CONSTRUCTOR })
public @interface LogExternalService {
}

package com.github.spring.aspect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.github.spring.aspect.ErrorHandlingAspect;
import com.github.spring.aspect.LoggingAspect;

/**
 * Annotation to mark methods for logging execution time. Methods annotated with
 * {@code @LogExecutionTime} will have their execution time logged by the
 * {@link LoggingAspect}.
 *
 * <p>
 * Example usage:
 * 
 * <pre>{@code
 * import com.github.spring.aspect.annotation..LogExecutionTime;
 *
 * {@literal @}LogExecutionTime
 * public void myMethod() {
 *     // Method implementation
 * }
 * }</pre>
 *
 * @see LoggingAspect
 * @see ErrorHandlingAspect
 * @see LogEntryExit
 * @see LogExceptions
 * @see LogExternalExceptions
 * @see NoLog
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE, ElementType.CONSTRUCTOR })
public @interface LogExecutionTime {
}

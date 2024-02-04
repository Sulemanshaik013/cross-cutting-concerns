package com.github.spring.aspect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.github.spring.aspect.ErrorHandlingAspect;
import com.github.spring.aspect.LoggingAspect;

/**
 * Annotation to mark methods for logging entry and exit. Methods annotated with
 * {@code @LogEntryExit} will have their entry and exit logged by the
 * {@link LoggingAspect}.
 *
 * <p>
 * Example usage:
 * 
 * <pre>{@code
 * import com.github.spring.aspect.annotation.LogEntryExit;
 *
 * {@literal @}LogEntryExit
 * public void myMethod() {
 *     // Method implementation
 * }
 * }</pre>
 *
 * @see LoggingAspect
 * @see ErrorHandlingAspect
 * @see LogExceptions
 * @see LogExecutionTime
 * @see LogExternalExceptions
 * @see NoLog
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE, ElementType.CONSTRUCTOR })
public @interface LogEntryExit {
}

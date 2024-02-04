package com.github.spring.aspect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.github.spring.aspect.ErrorHandlingAspect;
import com.github.spring.aspect.LoggingAspect;

/**
 * Annotation to exclude methods or classes from logging. Methods or classes
 * annotated with {@code @NoLog} will not have their entry and exit logged by
 * the {@link LoggingAspect}.
 *
 * <p>
 * Example usage:
 * 
 * <pre>{@code
 * import com.github.spring.aspect.annotation.NoLog;
 *
 * {@literal @}NoLog
 * public void myMethod() {
 *     // Method implementation
 * }
 * }</pre>
 *
 * @see LoggingAspect
 * @see ErrorHandlingAspect
 * @see LogEntryExit
 * @see LogExceptions
 * @see LogExecutionTime
 * @see LogExternalExceptions
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE, ElementType.CONSTRUCTOR })
public @interface NoLog {
}

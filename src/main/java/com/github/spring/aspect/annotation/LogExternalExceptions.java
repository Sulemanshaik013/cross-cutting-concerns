package com.github.spring.aspect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.github.spring.aspect.ErrorHandlingAspect;
import com.github.spring.aspect.LoggingAspect;

/**
 * Annotation to mark methods for logging vault exceptions. Methods annotated
 * with {@code @LogExternalExceptions} will have their vault-related exceptions
 * logged by the {@link LoggingAspect}.
 *
 * <p>
 * Example usage:
 * 
 * <pre>{@code
 * import com.github.spring.aspect.annotation..LogVaultExceptions;
 *
 * {@literal @}LogExternalExceptions
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
 * @see NoLog
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE, ElementType.CONSTRUCTOR })
public @interface LogExternalExceptions {
}

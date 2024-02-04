package com.github.spring.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import com.github.spring.exception.client.ForbiddenException;
import com.github.spring.exception.client.UnauthorizedException;
import com.github.spring.exception.custom.CustomException;
import com.github.spring.exception.custom.DataMissingException;
import com.github.spring.exception.custom.DuplicateEntryException;
import com.github.spring.exception.server.ResourceNotFoundException;
import com.github.spring.exception.server.ServiceUnavailableException;

/**
 *
 * Aspect for handling External API exceptions.
 *  
 */
@Aspect
@Configuration
public class ErrorHandlingAspect {

	/**
	 * Pointcut to exclude methods or classes in specified packages and annotated
	 * with {@Link NoLog}.
	 */
	@Pointcut("@within(com.github.spring.aspect.annotation.NoLog) || @annotation(com.github.spring.aspect.annotation.NoLog)")
	public void noLogPointcut() {
		// define packages or classes in pointcut to to exclude logs
	}

	/**
	 * Pointcut for for handling External API exceptions in specified packages and are
	 * annotated with @LogExternalExceptions.
	 */
	@Pointcut("within(com..apiclient.*) || @annotation(com.github.spring.aspect.annotation.LogExternalExceptions) || @within(com.github.spring.aspect.annotation.LogExternalExceptions)")
	public void externalAPIErrorsPointcut() {
		// define packages in pointcut to handle vault server exception
	}

	// @AfterThrowing(pointcut = "@annotation(LogExternalExceptions)", throwing = "e")
	@AfterThrowing(value = "externalAPIErrorsPointcut() && !noLogPointcut()", throwing = "ex")
	@ConditionalOnProperty(prefix = "logging.externalAPIs", name = "enabled", havingValue = "true", matchIfMissing = false)
	public void handleexternalAPIErrors(Exception ex) {
		if (isHttpErrorException(ex)) {
			HttpClientErrorException nestedHttpErrorException = findNestedHttpErrorException(ex);
			if (nestedHttpErrorException == null) {
				throw new CustomException(ex.getLocalizedMessage());
			}
			handleHttpClientErrorException(nestedHttpErrorException);
		} else if (ex instanceof ServiceUnavailableException) {
			throw new ServiceUnavailableException(ex.getMessage());
		} else if (ex instanceof DuplicateEntryException) {
			throw new DuplicateEntryException(ex.getMessage());
		} else if (ex instanceof ResourceNotFoundException) {
			throw new ResourceNotFoundException(ex.getMessage());
		} else if (ex instanceof UnauthorizedException) {
			throw new UnauthorizedException(ex.getMessage());
		} else if (ex instanceof ForbiddenException) {
			throw new ForbiddenException(ex.getMessage());
		} else {
			throw new CustomException(ex.getMessage());
		}
	}

	private HttpClientErrorException findNestedHttpErrorException(Throwable throwable) {
		while (throwable != null) {
			if (throwable instanceof HttpClientErrorException) {
				return (HttpClientErrorException) throwable;
			}
			throwable = throwable.getCause();
		}
		return null;
	}

	private boolean isHttpErrorException(Exception ex) {
		return ex instanceof HttpClientErrorException || ex instanceof HttpServerErrorException
				|| hasHttpErrorExceptionCause(ex);
	}

	private boolean hasHttpErrorExceptionCause(Throwable throwable) {
		while (throwable.getCause() != null) {
			if (throwable.getCause() instanceof HttpClientErrorException
					|| throwable.getCause() instanceof HttpServerErrorException) {
				return true;
			}
			throwable = throwable.getCause();
		}
		return false;
	}

	private void handleHttpClientErrorException(HttpClientErrorException httpClientErrorException) {
		switch (httpClientErrorException.getStatusCode()) {
		case NOT_FOUND:
			throw new ResourceNotFoundException(httpClientErrorException.getMessage());
		case BAD_REQUEST:
			throw new DataMissingException(httpClientErrorException.getMessage());
		case UNAUTHORIZED:
			throw new UnauthorizedException(httpClientErrorException.getMessage());
		case FORBIDDEN:
			throw new ForbiddenException(httpClientErrorException.getMessage());
		case CONFLICT:
			throw new DuplicateEntryException(httpClientErrorException.getMessage());
		case SERVICE_UNAVAILABLE:
			throw new ServiceUnavailableException(httpClientErrorException.getMessage());
		default:
			throw new CustomException(httpClientErrorException.getMessage());

		}
	}
}

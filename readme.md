# project for Cross-Cutting Concerns in Java Spring Boot micro-services
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

### Introduction

In a micro-services architecture, cross-cutting concerns such as exception handling, logging, interceptors, security and others need to be managed consistently across all services. This project centralizes the handling of these concerns, ensuring uniformity and reducing the complexity of individual micro-services.

### Objectives

The primary goal of this project is to provide a reusable solution that can be easily integrated into multiple micro-services. The focus areas include:

1. **Exception Handling**
2. **Logging**
3. **Interceptors**
4. **RestTemplate Error Handling**


#### Exception Handling

Exception handling is a critical aspect of any application, ensuring that errors are managed gracefully and informative responses are provided to clients. Your project defines a comprehensive set of custom exceptions to represent various error conditions.

##### Custom Exceptions

There are variety of custom exceptions can be implemented, each representing a specific error scenario. These exceptions are divided into client-side and server-side categories:

- Client-Side Exceptions (4xx Series)
- Server-Side Exceptions (5xx Series)
- You can add Custom Exceptions


##### Global Exception Handling

The project provides a global exception handling mechanism using Spring's `@ControllerAdvice`. This ensures that all exceptions are handled uniformly across all micro-services, providing consistent error responses.

#### Logging

Logging is essential for debugging, monitoring, and auditing. This project leverages aspect-oriented programming (AOP) to provide comprehensive logging capabilities.

##### Aspect-Oriented Logging

Here few aspects are created that automatically log method entry, exit, exceptions, and execution time. This approach ensures that logging is consistent and minimizes the need for repetitive logging code.

##### Configuration-Based Logging

The project allows logging to be configured through the `application.properties` file. This enables you to control logging behavior without changing the code, making it adaptable to different environments.



**Example: Configuration Properties**
```properties
logging.exceptionHandling.level=message_only
logging.logEntryExit.enabled=true
logging.logExceptions.enabled=true
logging.logExecutionTime.enabled=true
```
these are the values for the label: ` logging.exceptionHandling.level`
- `none` - No logging will occur for exceptions.
- `message_only` - Only the exception message will be logged.
- `stacktrace` - The full stack trace will be logged.

#### RestTemplate Error Handling

RestTemplate is a common choice for making HTTP calls in Spring Boot applications. Handling errors from these calls consistently is crucial. This project provides a custom error handler for RestTemplate to handle different HTTP error statuses and convert them into meaningful exceptions.

#### Interceptors

Interceptors are used to process requests and responses globally, enabling functionalities such as logging, authentication, and modifying responses. This project includes interceptors that handle Rest template external Calls.



     will update the project to add new cross-cutting concerns or enhance existing functionalities.


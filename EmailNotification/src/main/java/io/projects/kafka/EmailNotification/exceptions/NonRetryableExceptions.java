package io.projects.kafka.EmailNotification.exceptions;

public class NonRetryableExceptions extends RuntimeException{
    public NonRetryableExceptions(String message) {
        super(message);
    }

    public NonRetryableExceptions(Throwable cause) {
        super(cause);
    }
}

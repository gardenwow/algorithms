package org.example.Exception;

public class StringFullException extends RuntimeException {
    public StringFullException() {
    }

    public StringFullException(String message) {
        super(message);
    }

    public StringFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public StringFullException(Throwable cause) {
        super(cause);
    }

    public StringFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

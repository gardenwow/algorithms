package org.example.Exception;

public class IndexErrorException extends RuntimeException {
    public IndexErrorException() {
    }

    public IndexErrorException(String message) {
        super(message);
    }

    public IndexErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public IndexErrorException(Throwable cause) {
        super(cause);
    }

    public IndexErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

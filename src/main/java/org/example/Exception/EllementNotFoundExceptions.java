package org.example.Exception;

public class EllementNotFoundExceptions extends RuntimeException {
    public EllementNotFoundExceptions() {
    }

    public EllementNotFoundExceptions(String message) {
        super(message);
    }

    public EllementNotFoundExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public EllementNotFoundExceptions(Throwable cause) {
        super(cause);
    }

    public EllementNotFoundExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

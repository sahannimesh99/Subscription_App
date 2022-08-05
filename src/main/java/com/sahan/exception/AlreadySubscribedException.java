package com.sahan.exception;

/**
 *
 * @author Sahan Nimesha
 */

public class AlreadySubscribedException extends RuntimeException {
    public AlreadySubscribedException() {
    }

    public AlreadySubscribedException(String message) {
        super(message);
    }

    public AlreadySubscribedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlreadySubscribedException(Throwable cause) {
        super(cause);
    }

    public AlreadySubscribedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

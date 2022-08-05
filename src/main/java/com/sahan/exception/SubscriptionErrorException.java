package com.sahan.exception;

/**
 *
 * @author Sahan Nimesha
 */

public class SubscriptionErrorException extends RuntimeException {
    public SubscriptionErrorException() {
    }

    public SubscriptionErrorException(String message) {
        super(message);
    }

    public SubscriptionErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public SubscriptionErrorException(Throwable cause) {
        super(cause);
    }

    public SubscriptionErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

package com.sahan.exception;

/**
 *
 * @author Sahan Nimesha
 */

public class InvalidChannelException extends RuntimeException {
    public InvalidChannelException() {
    }

    public InvalidChannelException(String message) {
        super(message);
    }

    public InvalidChannelException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidChannelException(Throwable cause) {
        super(cause);
    }

    public InvalidChannelException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

package com.sahan.exception;

/**
 *
 * @author Sahan Nimesha
 */

public class DuplicateChannelException extends RuntimeException {
    public DuplicateChannelException() {
    }

    public DuplicateChannelException(String message) {
        super(message);
    }

    public DuplicateChannelException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateChannelException(Throwable cause) {
        super(cause);
    }

    public DuplicateChannelException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

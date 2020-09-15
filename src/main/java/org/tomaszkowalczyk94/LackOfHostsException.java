package org.tomaszkowalczyk94;

public class LackOfHostsException extends RuntimeException {
    public LackOfHostsException() {
        super();
    }

    public LackOfHostsException(String message) {
        super(message);
    }

    public LackOfHostsException(String message, Throwable cause) {
        super(message, cause);
    }

    public LackOfHostsException(Throwable cause) {
        super(cause);
    }

    protected LackOfHostsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

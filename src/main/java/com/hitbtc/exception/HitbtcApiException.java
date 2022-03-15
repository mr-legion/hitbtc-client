package com.hitbtc.exception;

import com.hitbtc.HitbtcApiError;

/**
 * An exception which can occur while invoking methods of the HitBTC API.
 */
public class HitbtcApiException extends RuntimeException {

    private static final long serialVersionUID = -2754906214286094269L;

    private HitbtcApiError error;

    public HitbtcApiException(HitbtcApiError error) {
        this.error = error;
    }

    public HitbtcApiException() {
        super();
    }

    public HitbtcApiException(String message) {
        super(message);
    }

    public HitbtcApiException(Throwable cause) {
        super(cause);
    }

    public HitbtcApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @return the response error object from HitBTC API,
     * or null if no response object was returned (e.g. server returned 500).
     */
    public HitbtcApiError getError() {
        return error;
    }

    @Override
    public String getMessage() {
        if (error != null) {
            return error.getMessage();
        }
        return super.getMessage();
    }
}

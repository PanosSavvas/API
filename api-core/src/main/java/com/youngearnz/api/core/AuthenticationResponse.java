package com.youngearnz.api.core;

/**
 * Created by can on 26/10/14.
 */
public class AuthenticationResponse {

    private boolean success;

    public AuthenticationResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}

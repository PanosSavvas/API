package com.youngearnz.api.core;

import org.joda.time.DateTime;

/**
 * Created by can on 26/10/14.
 */
public class RegistrationResponse {

    private boolean result;
    private String message;
    private String id;

    public RegistrationResponse(boolean result, String message, String id) {
        this.result = result;
        this.message = message;
        this.id = id;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }
}

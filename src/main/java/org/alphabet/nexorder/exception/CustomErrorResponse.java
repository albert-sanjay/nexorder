package org.alphabet.nexorder.exception;

import java.time.ZonedDateTime;

public class CustomErrorResponse {
    private ZonedDateTime timestamp;
    private String error;
    private int status;

    public CustomErrorResponse(String error, int status) {
        this.timestamp = ZonedDateTime.now();
        this.error = error;
        this.status = status;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public String getError() {
        return error;
    }

    public int getStatus() {
        return status;
    }
}

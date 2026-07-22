package com.diacore.response;

import java.time.OffsetDateTime;

public class ResponseResponse<T> {
    private final OffsetDateTime timestamp;
    private final int status;
    private final String code;
    private final String message;
    private final T data;

    private ResponseResponse(ResponseCode responseCode, String message, T data) {
        this.timestamp = OffsetDateTime.now();
        this.status = responseCode.getStatus().value();
        this.code = responseCode.getCode();
        this.message = (message != null) ? message : responseCode.getMessage();
        this.data = data;
    }

    public static <T> ResponseResponse<T> of(ResponseCode responseCode) {
        return new ResponseResponse<>(responseCode, null, null);
    }

    public static <T> ResponseResponse<T> of(ResponseCode successCode, T data) {
        return new ResponseResponse<>(successCode, null, data);
    }

    public static <T> ResponseResponse<T> of(ResponseCode successCode, String customMessage, T data) {
        return new ResponseResponse<>(successCode, customMessage, data);
    }

    public OffsetDateTime getTimestamp() { return timestamp; }
    public int getStatus() { return status; }
    public String getCode() { return code; }
    public String getMessage() { return message; }
    public T getData() { return data; }
}

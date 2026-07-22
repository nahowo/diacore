package com.diacore.response;

import org.springframework.http.HttpStatus;

public enum ResponseCode {
    OK(HttpStatus.OK, "S001", "요청이 성공적으로 처리되었습니다."),
    CREATED(HttpStatus.CREATED, "S002", "성공적으로 생성되었습니다."),
    NO_CONTENT(HttpStatus.NO_CONTENT, "S003", "성공적으로 처리되었습니다."),

    USER_REGISTER_SUCCESS(HttpStatus.CREATED, "SU01", "회원가입이 완료되었습니다."),
    USER_LOGIN_SUCCESS(HttpStatus.OK, "SU02", "로그인에 성공했습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

    ResponseCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getStatus() { return status; }
    public String getCode() { return code; }
    public String getMessage() { return message; }
}

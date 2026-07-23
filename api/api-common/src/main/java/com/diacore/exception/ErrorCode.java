package com.diacore.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "C001", "잘못된 입력값입니다."),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "C002", "지원하지 않는 HTTP 메서드입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "C003", "서버 내부 오류가 발생했습니다."),
    INVALID_TYPE_VALUE(HttpStatus.BAD_REQUEST, "C004", "요청 파라미터의 타입이 올바르지 않습니다."),
    MISSING_REQUEST_PARAMETER(HttpStatus.BAD_REQUEST, "C005", "필수 요청 파라미터가 누락되었습니다."),

    DUPLICATE_EMAIL(HttpStatus.BAD_REQUEST, "U001", "이미 사용 중인 이메일입니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "U002", "가입되지 않은 이메일입니다."),
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST, "U003", "비밀번호가 일치하지 않습니다."),
    UNAUTHORIZED_USER(HttpStatus.UNAUTHORIZED, "U004", "인증 정보가 없습니다. 로그인이 필요합니다."),

    THERAPY_CR_NOT_FOUND(HttpStatus.NOT_FOUND, "T001", "탄수비 설정이 없습니다."),
    THERAPY_ISF_NOT_FOUND(HttpStatus.NOT_FOUND, "T001", "인슐린 민감도 설정이 없습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

    ErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getStatus() { return status; }
    public String getCode() { return code; }
    public String getMessage() { return message; }
}

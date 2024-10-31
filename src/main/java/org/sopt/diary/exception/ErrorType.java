package org.sopt.diary.exception;

import org.springframework.http.HttpStatus;

public enum ErrorType {
    REQUEST_VALIDATION_ERROR(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    DUPLICATE_NICKNAME_ERROR(HttpStatus.BAD_REQUEST, "중복된 닉네임입니다."),
    MEMBER_NOTFOUND_ERROR(HttpStatus.BAD_REQUEST, "존재하지 않는 회원입니다.");
    private final HttpStatus httpStatus;
    private final String message;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    ErrorType(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}

package org.sopt.diary.exception;

import org.springframework.http.HttpStatus;

public enum ErrorType {
    REQUEST_VALIDATION_ERROR(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    DUPLICATE_NICKNAME_ERROR(HttpStatus.BAD_REQUEST, "중복된 닉네임입니다."),
    MEMBER_NOTFOUND_ERROR(HttpStatus.BAD_REQUEST, "존재하지 않는 멤버입니다."),
    DUPLICATE_TITLE_ERROR(HttpStatus.BAD_REQUEST, "중복된 일기 제목입니다."),
    LOGIN_ERROR(HttpStatus.BAD_REQUEST, "로그인 후 이용해주세요."),
    DIARY_NOTFOUND_ERROR(HttpStatus.BAD_REQUEST, "존재하지 않는 일기입니다."),
    INVALID_MEMBER(HttpStatus.UNAUTHORIZED, "본인이 작성한 일기에만 접근할 수 있습니다.");
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

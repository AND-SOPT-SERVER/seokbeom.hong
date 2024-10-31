package org.sopt.diary.api.dto;

public class MemberLoginResponse {
    private Long userId;

    public MemberLoginResponse(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}

package org.sopt.diary.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MemberLoginRequest {
    @NotNull
    @NotBlank
    private String nickName;

    @NotNull
    @NotBlank
    private String password;

    public String getNickName() {
        return nickName;
    }

    public String getPassword() {
        return password;
    }
}

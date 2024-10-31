package org.sopt.diary.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MemberSignUpRequest {

    @NotNull
    @NotBlank
    private String userName;

    @NotNull
    @NotBlank
    private String nickName;

    @NotNull
    @NotBlank
    private String password;

    public String getUserName() {
        return userName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getPassword() {
        return password;
    }
}

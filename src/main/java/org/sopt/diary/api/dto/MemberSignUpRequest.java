package org.sopt.diary.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MemberSignUpRequest {

    @NotNull(message = "유저이름은 null일 수 없습니다.")
    @NotBlank(message = "유저이름은 공백일 수 없습니다.")
    private String userName;

    @NotNull(message = "닉네임은 null일 수 없습니다.")
    @NotBlank(message = "닉네임은 공백일 수 없습니다.")
    private String nickName;

    @NotNull(message = "비빌번호는 null일 수 없습니다.")
    @NotBlank(message = "비빌번호는 공백일 수 없습니다.")
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

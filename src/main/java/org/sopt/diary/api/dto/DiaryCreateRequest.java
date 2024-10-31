package org.sopt.diary.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

public class DiaryCreateRequest {

    private String name;
    @NotBlank(message = "일기의 제목은 공백일 수 없습니다.")
    @Size(min = 1, max = 10, message = "일기 제목의 글자수는 1~10자여야 합니다.")
    private String title;

    @NotBlank(message = "일기의 본문은 공백일 수 없습니다.")
    @Size(min = 1, max = 30, message = "일기의 글자수는 1~30자여야 합니다.")
    private String content;

    public DiaryCreateRequest(final String name, final String title, final String content) {
        this.name = name;
        this.title = title;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
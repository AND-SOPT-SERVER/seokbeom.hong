package org.sopt.diary.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.sopt.diary.repository.Category;

public class DiaryCreateRequest {

    @NotBlank(message = "일기의 제목은 공백일 수 없습니다.")
    @Size(min = 1, max = 10, message = "일기 제목의 글자수는 1~10자여야 합니다.")
    private String title;

    @NotBlank(message = "일기의 본문은 공백일 수 없습니다.")
    @Size(min = 1, max = 30, message = "일기의 글자수는 1~30자여야 합니다.")
    private String content;

    @NotNull(message = "카테고리는 필수 항목입니다.")
    private Category category;

    private boolean isShare;

    public Category getCategory() {
        return category;
    }

    public DiaryCreateRequest(final String title, final String content, final Category category, boolean isShare) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.isShare = isShare;
    }


    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public boolean getIsShare() {
        return isShare;
    }
}
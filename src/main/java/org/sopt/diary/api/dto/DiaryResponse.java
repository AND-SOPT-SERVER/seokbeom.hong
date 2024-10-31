package org.sopt.diary.api.dto;

import java.time.LocalDate;

public class DiaryResponse {

    private long id;
    private String title;
    private String nickName;
    private String content;
    private LocalDate createdAt;

    public DiaryResponse(long id, String title, String nickName, String content, LocalDate createdAt) {
        this.id = id;
        this.title = title;
        this.nickName = nickName;
        this.content = content;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getNickName() {
        return nickName;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}

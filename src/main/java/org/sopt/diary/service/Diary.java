package org.sopt.diary.service;

import java.time.LocalDate;

public class Diary {
    private final long id;
    private final String title;
    private final String nickName;
    private final String content;
    private final LocalDate createdAt;

    public Diary(long id, String title, String nickName, String content, LocalDate createdAt) {
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
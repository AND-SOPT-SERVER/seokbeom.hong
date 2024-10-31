package org.sopt.diary.api.dto;

public class DiaryCreateRequest {

    private String name;
    private String title;
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
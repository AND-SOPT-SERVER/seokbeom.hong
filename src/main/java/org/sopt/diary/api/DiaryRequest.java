package org.sopt.diary.api;

public class DiaryRequest {

    private String name;
    private String title;
    private String content;

    public DiaryRequest(final String name, final String title, final String content) {
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
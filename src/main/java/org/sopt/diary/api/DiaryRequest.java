package org.sopt.diary.api;

public class DiaryRequest {

    private String name;
    private String title;
    private String content;
    private String category;

    public DiaryRequest(final String name, final String title, final String content, final String category) {
        this.name = name;
        this.title = title;
        this.content = content;
        this.category = category;
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

    public String getCategory() {
        return category;
    }
}
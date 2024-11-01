package org.sopt.diary.api;

public class DiaryCategoryResponse {

    private long id;
    private String title;
    private String category;
    private String content;

    public DiaryCategoryResponse(final long id, final String title, final String category, final String content) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }
}
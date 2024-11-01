package org.sopt.diary.api;

public class DiaryPatchRequest {
    private String title;
    private String category;
    private String content;

    public DiaryPatchRequest(final String title, final String content, final String category) {
        this.title = title;
        this.category = category;
        this.content = content;
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

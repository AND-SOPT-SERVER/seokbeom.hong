package org.sopt.diary.api;

public class DiaryPatchRequest {
    private String title;
    private String content;

    public DiaryPatchRequest(final String title, final String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

}

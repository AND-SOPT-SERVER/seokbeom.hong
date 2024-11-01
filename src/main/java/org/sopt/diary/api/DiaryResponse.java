package org.sopt.diary.api;

public class DiaryResponse {

    private long id;
    private String name;
    private String category;

    public DiaryResponse(long id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
}

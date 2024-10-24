package org.sopt.diary.service;

public class Diary {
    private final long id;
    private final String name;
    private final String category;

    public Diary(long id, String name, String category) {
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

package org.sopt.diary.repository;

public enum Category {
    FOOD("음식"),
    SCHOOL("학교"),
    MOVIE("영화"),
    HEALTH("운동");

    private final String category;

    public String getCategory() {
        return category;
    }

    Category(String category) {
        this.category = category;
    }
}

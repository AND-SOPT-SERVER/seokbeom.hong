package org.sopt.diary.api;

import java.time.LocalDate;

public class DiaryDetailResponse {
    private Long id;
    private String name;
    private String category;
    private String title;
    private String content;
    private LocalDate createdAt;


    public DiaryDetailResponse(final Long id, final String name, final String title, final String content,
                               final String category,
                               final LocalDate createdAt) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.category = category;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}


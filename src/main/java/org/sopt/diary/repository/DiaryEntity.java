package org.sopt.diary.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class DiaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String title;

    @Column
    private String category;

    @Column
    private String content;

    @Column
    private int contentLength;

    @Column
    private LocalDate createdAt;

    @Column
    private LocalDateTime updatedAt;

    public DiaryEntity() {
    }

    public DiaryEntity(final String name, final String title, final String content, final String category) {
        this.name = name;
        this.title = title;
        this.content = content;
        this.category = category;
        this.contentLength = content.length();
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDateTime.now();
    }

    // 왜 소문자 long일까
    public long getId() {
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getCategory() {
        return category;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setContent(final String content) {
        this.content = content;
        this.contentLength = content.length();
    }

    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }
}
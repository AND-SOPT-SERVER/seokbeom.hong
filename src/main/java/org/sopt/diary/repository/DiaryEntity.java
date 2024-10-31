package org.sopt.diary.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "hsb_diary")
public class DiaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private int contentLength;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private Category category;

    @Column
    private LocalDate createdAt;

    @Column
    private LocalDate updatedAt;

    @Column(name = "is_share")
    private boolean isShare;

    public DiaryEntity() {
    }

    public DiaryEntity(final Long userId, final String title, final String content, final Category category, boolean isShare) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.contentLength = content.length();
        this.category = category;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
        this.isShare = isShare;
    }

    // 왜 소문자 long일까
    public long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public Long getUserId() {
        return userId;
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

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setContent(final String content) {
        this.content = content;
        this.contentLength = content.length();
    }

    public void setUpdatedAt() {
        this.updatedAt = LocalDate.now();
    }
}
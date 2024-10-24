package org.sopt.diary.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class DiaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String name;

    @Column
    public String title;

    @Column
    public String content;

    @Column
    public int contentLength;

    @Column
    public LocalDate createdAt;

    @Column
    public LocalDate updatedAt;

    public DiaryEntity() {

    }

    public DiaryEntity(final String name, final String title, final String content) {
        this.name = name;
        this.title = title;
        this.content = content;
        this.contentLength = content.length();
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    // 왜 소문자 long일까
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

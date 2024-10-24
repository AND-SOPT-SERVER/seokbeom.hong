package org.sopt.diary.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DiaryRepository extends JpaRepository<DiaryEntity, Long> {
    @Query("SELECT d FROM DiaryEntity d ORDER BY d.contentLength DESC, d.id DESC")
    List<DiaryEntity> findTop10ByOrderByContentLengthDesc();
    Optional<DiaryEntity> findTop1ByOrderByIdDesc();
    Optional<DiaryEntity> findByTitle(final String title);

    List<DiaryEntity> findAllByCategory(String category);
}

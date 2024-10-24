package org.sopt.diary.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<DiaryEntity, Long> {
    List<DiaryEntity> findTop10ByOrderByIdDesc();
}

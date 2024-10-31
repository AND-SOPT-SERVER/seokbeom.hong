package org.sopt.diary.repository;

import java.util.List;
import java.util.Optional;
import org.sopt.diary.exception.CustomException;
import org.sopt.diary.exception.ErrorType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<DiaryEntity, Long> {
    List<DiaryEntity> findTop10ByIsShareTrueOrderByIdDesc();
    List<DiaryEntity> findTop10ByUserIdOrderByIdDesc(Long userId);

    Optional<DiaryEntity> findById(Long id);

    default DiaryEntity findByIdOrThrow(Long id) {
        DiaryEntity diary = findById(id)
                .orElseThrow(() -> new CustomException(ErrorType.DIARY_NOTFOUND_ERROR));
        return diary;
    }

    boolean existsByTitle(String title);
}

package org.sopt.diary.repository;

import java.util.List;
import java.util.Optional;
import org.sopt.diary.exception.CustomException;
import org.sopt.diary.exception.ErrorType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<DiaryEntity, Long> {
    // 1. isShare가 true이고 카테고리별 최신순 상위 10개
    List<DiaryEntity> findTop10ByIsShareTrueAndCategoryOrderByCreatedAtDesc(Category category);

    // 2. isShare가 true이고 카테고리별 글자수 내림차순
    List<DiaryEntity> findByIsShareTrueAndCategoryOrderByContentLengthDesc(Category category);

    // 3. 특정 유저의 카테고리별 최신순 상위 10개
    List<DiaryEntity> findTop10ByUserIdAndCategoryOrderByCreatedAtDesc(Long userId, Category category);

    // 4. 특정 유저의 카테고리별 글자수 내림차순
    List<DiaryEntity> findByUserIdAndCategoryOrderByContentLengthDesc(Long userId, Category category);

    Optional<DiaryEntity> findById(Long id);

    default DiaryEntity findByIdOrThrow(Long id) {
        DiaryEntity diary = findById(id)
                .orElseThrow(() -> new CustomException(ErrorType.DIARY_NOTFOUND_ERROR));
        return diary;
    }

    boolean existsByTitle(String title);
}

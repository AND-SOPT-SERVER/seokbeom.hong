package org.sopt.diary.service;

import jakarta.persistence.EntityNotFoundException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.sopt.diary.api.DiaryDetailResponse;
import org.sopt.diary.api.DiaryPatchRequest;
import org.sopt.diary.api.DiaryRequest;
import org.sopt.diary.repository.DiaryEntity;
import org.sopt.diary.repository.DiaryRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DiaryService {
    private final DiaryRepository diaryRepository;

    public DiaryService(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    @Transactional
    public void createDiary(final DiaryRequest diaryRequest){
        Optional<DiaryEntity> lastDiary = diaryRepository.findTop1ByOrderByIdDesc();
        if (lastDiary.isPresent()) {
            DiaryEntity lastOne = lastDiary.get();

            LocalDateTime lastUpdatedAt = lastOne.getUpdatedAt();
            LocalDateTime now = LocalDateTime.now();
            Duration duration = Duration.between(lastUpdatedAt, now);

            // 5분 이내면 예외 발생
            if (duration.toMinutes() < 5) {
                throw new RuntimeException("마지막 일기 작성 후 5분이 지나지 않았습니다.");
            }
        }

        Optional<DiaryEntity> existTitle = diaryRepository.findByTitle(diaryRequest.getTitle());
        if (existTitle.isPresent()) {
            throw new RuntimeException("중복되는 제목이 존재합니다.");
        }

        DiaryEntity diary = new DiaryEntity(diaryRequest.getName(), diaryRequest.getTitle(),
                diaryRequest.getContent(), diaryRequest.getCategory());
        diaryRepository.save(diary);
    }

    @Transactional(readOnly = true)
    public List<Diary> getList() {
        final List<DiaryEntity> diaryEntityList = diaryRepository.findTop10ByOrderByContentLengthDesc();
        final List<Diary> diaryList = new ArrayList<>();

        for (DiaryEntity diaryEntity : diaryEntityList) {
            diaryList.add(
                    new Diary(diaryEntity.getId(), diaryEntity.getName(), diaryEntity.getCategory())
            );
        }
        return diaryList;
    }

    @Transactional(readOnly = true)
    public DiaryDetailResponse getDetail(final Long id) {
        final DiaryEntity diary = diaryRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return new DiaryDetailResponse(diary.getId(), diary.getName(), diary.getTitle(), diary.getContent(),
                diary.getCategory(), diary.getCreatedAt()
        );
    }

    @Transactional
    public void patchDiary(final Long id, DiaryPatchRequest diaryPatchRequest) {
        final DiaryEntity diary = diaryRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        diary.setTitle(diaryPatchRequest.getTitle());
        diary.setContent(diaryPatchRequest.getContent());
        diary.setCategory(diaryPatchRequest.getCategory());
        diary.setUpdatedAt();
    }

    @Transactional
    public void deleteDiary(final Long id) {
        final DiaryEntity diary = diaryRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        diaryRepository.delete(diary);
    }
}

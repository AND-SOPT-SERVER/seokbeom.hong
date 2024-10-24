package org.sopt.diary.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
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
    public void createDiary(final DiaryRequest diaryRequest) {
        DiaryEntity diary = new DiaryEntity(diaryRequest.getName(), diaryRequest.getTitle(),
                diaryRequest.getContent());
        diaryRepository.save(diary);
    }

    @Transactional(readOnly = true)
    public List<Diary> getList() {
        final List<DiaryEntity> diaryEntityList = diaryRepository.findTop10ByOrderByIdDesc();
        final List<Diary> diaryList = new ArrayList<>();

        for (DiaryEntity diaryEntity : diaryEntityList) {
            diaryList.add(
                    new Diary(diaryEntity.getId(), diaryEntity.getName())
            );
        }

        return diaryList;
    }

    @Transactional(readOnly = true)
    public DiaryDetailResponse getDetail(final Long id) {
        final DiaryEntity diary = diaryRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return new DiaryDetailResponse(diary.getId(), diary.getName(), diary.getTitle(), diary.getContent(),
                diary.getCreatedAt());
    }

    @Transactional
    public void patchDiary(final Long id, DiaryPatchRequest diaryPatchRequest) {
        final DiaryEntity diary = diaryRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        diary.setTitle(diaryPatchRequest.getTitle());
        diary.setContent(diaryPatchRequest.getContent());
        diary.setUpdatedAt();
    }
}

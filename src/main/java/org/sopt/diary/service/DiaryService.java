package org.sopt.diary.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.sopt.diary.api.dto.DiaryDetailResponse;
import org.sopt.diary.api.dto.DiaryPatchRequest;
import org.sopt.diary.api.dto.DiaryCreateRequest;
import org.sopt.diary.exception.CustomException;
import org.sopt.diary.exception.ErrorType;
import org.sopt.diary.repository.DiaryEntity;
import org.sopt.diary.repository.DiaryRepository;
import org.sopt.diary.repository.MemberEntity;
import org.sopt.diary.repository.MemberRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DiaryService {
    private final DiaryRepository diaryRepository;
    private final MemberRepository memberRepository;

    public DiaryService(DiaryRepository diaryRepository, MemberRepository memberRepository) {
        this.diaryRepository = diaryRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void createDiary(final String userId, final DiaryCreateRequest diaryCreateRequest) {
        if (diaryRepository.existsByTitle(diaryCreateRequest.getTitle())) {
            throw new CustomException(ErrorType.DUPLICATE_TITLE_ERROR);
        }
        DiaryEntity diary = new DiaryEntity(Long.parseLong(userId), diaryCreateRequest.getTitle(),
                diaryCreateRequest.getContent(), diaryCreateRequest.getCategory());
        diaryRepository.save(diary);
    }

    @Transactional(readOnly = true)
    public List<Diary> getList() {
        final List<DiaryEntity> diaryEntityList = diaryRepository.findTop10ByOrderByIdDesc();
        final List<Diary> diaryList = new ArrayList<>();

        for (DiaryEntity diaryEntity : diaryEntityList) {
            diaryList.add(
                    new Diary(diaryEntity.getId(), findNameById(diaryEntity.getId()))
            );
        }

        return diaryList;
    }

    @Transactional(readOnly = true)
    public DiaryDetailResponse getDetail(final Long id) {
        final DiaryEntity diary = diaryRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return new DiaryDetailResponse(diary.getId(), findNameById(diary.getUserId()), diary.getTitle(), diary.getContent(),
                diary.getCreatedAt());
    }

    @Transactional
    public void patchDiary(final Long id, DiaryPatchRequest diaryPatchRequest) {
        final DiaryEntity diary = diaryRepository.findByIdOrThrow(id);
        diary.setTitle(diaryPatchRequest.getTitle());
        diary.setContent(diaryPatchRequest.getContent());
        diary.setUpdatedAt();
    }

    @Transactional
    public void deleteDiary(final Long id) {
        final DiaryEntity diary = diaryRepository.findByIdOrThrow(id);
        diaryRepository.delete(diary);
    }

    @Transactional(readOnly = true)
    public String findNameById(Long id) {
        MemberEntity member = memberRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorType.MEMBER_NOTFOUND_ERROR));
        return member.getUserName();
    }
}

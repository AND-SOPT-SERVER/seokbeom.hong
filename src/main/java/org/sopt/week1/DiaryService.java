package org.sopt.week1;

import java.util.List;

public class DiaryService {
    private final DiaryRepository diaryRepository = new DiaryRepository();

    void postDiary(final String body) {
        final Diary diary = new Diary(null, body);
        diaryRepository.save(diary);
    }

    void deleteDiary(final String id) {
        diaryRepository.delete(Long.parseLong(id));
    }

    List<Diary> getDiaryList() {
        return diaryRepository.findAll();
    }

    void patchDiary(final String id, final String body) {
        diaryRepository.patch(Long.parseLong(id), body);
    }
}

package org.sopt.week1;

import java.time.LocalDate;
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
        Diary diary = diaryRepository.findDiaryById(Long.parseLong(id));
        // 같은 날에 수정하는 경우
        if (diary.getModifiedDate().equals(LocalDate.now())) {
            int modifiedCount = diary.getModifiedCount();
            if (modifiedCount == 2) {
                System.out.println("일기는 하루에 2번까지만 수정할 수 있습니다.");
            } else {
                diary.setModifiedCount(++modifiedCount);
                diary.setBody(body);
                diaryRepository.patch(diary);
            }
        } else {
            // 생성자에서 수정횟수와 수정날짜를 초기화해줌
            diary.setModifiedCount(0);
            diary.setModifiedDate(LocalDate.now());
            diaryRepository.patch(diary);
        }
    }

    void restoreDiary(final String id) {
        diaryRepository.restore(Long.parseLong(id));
    }
}

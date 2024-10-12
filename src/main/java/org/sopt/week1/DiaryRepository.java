package org.sopt.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class DiaryRepository {
    private final Map<Long, Diary> storage = new ConcurrentHashMap<>();
    private final AtomicLong numbering = new AtomicLong();

    void save(final Diary diary) {
        // 채번 과정
        final long id = numbering.addAndGet(1);
        diary.setId(id);
        // 저장 과정
        storage.put(id, diary);
    }

    void delete(final Long id) {
        Diary diary = findDiaryById(id);
        // 일기 복구 기능을 위해 소프트딜리트로 변경
        diary.setDelete(true);
        storage.put(id, diary);
    }

    List<Diary> findAll() {

        // (1) diary를 담을 자료구조
        List<Diary> diaryList = new ArrayList<>();

        // (2) 저장한 값을 불러오는 반복 구조
        for (long index = 1; index <= numbering.longValue(); index++) {
            Diary diary = storage.get(index);
            final boolean isDelete = diary.getDeleteStatus();

            // (2-1) 불러온 값을 구성한 자료구조로 이관
            // 삭제 되지 않은 일기만을 조회
            if (!isDelete) {
                diaryList.add(diary);
            }
        }
        // (3) 불러온 자료구조를 응답
        return diaryList;
    }

    void patch(final Diary diary) {
        storage.put(diary.getId(), diary);
    }

    void restore(final Long id) {
        Diary diary = findDiaryById(id);
        diary.setDelete(false);
        storage.put(id, diary);
    }

    Diary findDiaryById(final Long id) {
        Diary diary = null;
        if (storage.containsKey(id)) {
            diary = storage.get(id);
        }else{
            // 아이디에 매핑된 일기가 없을 경우 예외 처리
            System.out.println("해당 아이디의 일기가 존재하지 않습니다.");
        }
        return diary;
    }
}


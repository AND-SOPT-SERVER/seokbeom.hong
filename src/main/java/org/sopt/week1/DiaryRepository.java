package org.sopt.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class DiaryRepository {
    private final Map<Long, String> storage = new ConcurrentHashMap<>();
    private final AtomicLong numbering = new AtomicLong();

    void save(final Diary diary) {
        // 채번 과정
        final long id = numbering.addAndGet(1);

        // 저장 과정
        storage.put(id, diary.getBody());
    }

    void delete(final Long id) {
        if (storage.containsKey(id)) {
            storage.remove(id);
        }else{
            System.out.println("해당 아이디의 일기가 존재하지 않습니다.");
        }
    }

    List<Diary> findAll() {

        // (1) diary를 담을 자료구조
        List<Diary> diaryList = new ArrayList<>();

        // (2) 저장한 값을 불러오는 반복 구조
        for (long index = 1; index <= numbering.longValue(); index++) {
            final String body = storage.get(index);

            // (2-1) 불러온 값을 구성한 자료구조로 이관
            // 키값에 해당하는 값이 삭제된 경우 null이 저장되기 때문에, 제외시켜줌
            if (body != null) {
                diaryList.add(new Diary(index, body));
            }
        }
        // (3) 불러온 자료구조를 응답
        return diaryList;
    }

    void patch(final Long id, final String body) {
        if (storage.containsKey(id)) {
            // put 메서드로 덮어쓰기
            storage.put(id, body);
        }else{
            // 아이디에 매핑된 일기가 없을 경우 예외 처리
            System.out.println("해당 아이디의 일기가 존재하지 않습니다.");
        }
    }
}


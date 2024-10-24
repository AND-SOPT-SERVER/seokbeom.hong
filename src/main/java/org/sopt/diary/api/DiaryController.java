package org.sopt.diary.api;

import java.util.ArrayList;
import java.util.List;
import org.sopt.diary.service.Diary;
import org.sopt.diary.service.DiaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiaryController {
    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @PostMapping("/diary")
    ResponseEntity<String> post(
            @RequestBody DiaryRequest diaryRequest
    ) {
        if (diaryRequest.getContent().length() > 30) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("일기는 30자까지만 작성할 수 있습니다.");
        }
        diaryService.createDiary(diaryRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/diary")
    ResponseEntity<DiaryListResponse> get() {
        List<Diary> diaryList = diaryService.getList();
        List<DiaryResponse> diaryResponseList = new ArrayList<>();

        for (Diary diary : diaryList) {
            diaryResponseList.add(new DiaryResponse(diary.getId(), diary.getName()));
        }

        return ResponseEntity.ok(new DiaryListResponse(diaryResponseList));
    }
}

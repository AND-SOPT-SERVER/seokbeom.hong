package org.sopt.diary.api;

import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import org.sopt.diary.api.dto.DiaryDetailResponse;
import org.sopt.diary.api.dto.DiaryListResponse;
import org.sopt.diary.api.dto.DiaryPatchRequest;
import org.sopt.diary.api.dto.DiaryCreateRequest;
import org.sopt.diary.api.dto.DiaryResponse;
import org.sopt.diary.service.Diary;
import org.sopt.diary.service.DiaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
            @Valid @RequestBody final DiaryCreateRequest diaryCreateRequest
    ) {
        diaryService.createDiary(diaryCreateRequest);
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

    @GetMapping("/diary/{id}")
    ResponseEntity<DiaryDetailResponse> getDetail(
            @PathVariable final Long id
    ) {
        return ResponseEntity.ok(diaryService.getDetail(id));
    }

    @PatchMapping("/diary/{id}")
    ResponseEntity<String> patch(
            @PathVariable final Long id,
            @RequestBody final DiaryPatchRequest diaryPatchRequest
    ) {
        if (diaryPatchRequest.getContent().length() > 30) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("일기는 30자까지만 작성할 수 있습니다.");
        }
        diaryService.patchDiary(id, diaryPatchRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/diary/{id}")
    ResponseEntity<Void> delete(
            @PathVariable final Long id
    ) {
        diaryService.deleteDiary(id);
        return ResponseEntity.ok().build();
    }
}

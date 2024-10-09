package org.sopt.week1;

import java.util.List;

public class DiaryController {
    private Status status = Status.READY;
    private final DiaryService diaryService = new DiaryService();

    Status getStatus() {
        return status;
    }

    void boot() {
        this.status = Status.RUNNING;
    }

    void finish() {
        this.status = Status.FINISHED;
    }

    // APIS
    final List<Diary> getList() {
        return diaryService.getDiaryList();
    }

    final void post(final String body) {
        //todo: 이모지나 아랍어같은 값이 들어왔을 때 어떻게 글자수를 체크할 것인지
        if (body.length() > 30) {
            throw new IllegalArgumentException();
        }
        diaryService.postDiary(body);
    }

    final void delete(final String id) {
        diaryService.deleteDiary(id);
    }

    final void patch(final String id, final String body) {
        diaryService.patchDiary(id, body);
    }

    final void restore(final String id) {
        diaryService.restoreDiary(id);
    }

    enum Status {
        READY,
        RUNNING,
        FINISHED,
        ERROR,
    }
}

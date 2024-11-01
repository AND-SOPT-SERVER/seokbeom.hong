package org.sopt.week1;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Pattern graphemePattern = Pattern.compile("\\X");
        Matcher graphemeMatcher = graphemePattern.matcher("");

        graphemeMatcher.reset(body);
        int count = 0;
        while (graphemeMatcher.find()) {
            count++;
        }

        System.out.println("글자수 : " + count);
        if (count > 30) {
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

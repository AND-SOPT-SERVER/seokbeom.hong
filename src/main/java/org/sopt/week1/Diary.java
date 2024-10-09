package org.sopt.week1;

import java.time.LocalDate;

public class Diary {
    private Long id;
    private String body;
    private boolean isDelete;
    private final LocalDate modifiedDate;
    private int modifiedCount;
    public Diary(Long id, String body) {
        this.id = id;
        this.body = body;
        this.isDelete = false;
        this.modifiedDate = LocalDate.now();
        modifiedCount = 0;
    }
    public Long getId() {
        return id;
    }
    public String getBody() {
        return body;
    }
    public boolean getDeleteStatus() {
        return isDelete;
    }
    public void setDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void addModifiedCount() {
        this.modifiedCount++;
    }

    public LocalDate getDate() {
        return modifiedDate;
    }
}

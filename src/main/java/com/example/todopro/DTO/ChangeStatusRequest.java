package com.example.todopro.DTO;

import com.example.todopro.Model.TaskStatus;

public class ChangeStatusRequest {
    private TaskStatus status;

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}

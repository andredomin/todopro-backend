package com.example.todopro.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "todo")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @Enumerated(EnumType.STRING)
    private TaskStatus status = TaskStatus.INCOMPLETA;

    public void changeStatus(TaskStatus newStatus) {
        this.status = newStatus;
    }
    public TaskStatus getStatus() {
        return status;
    }


    public Task() {}

    public Task(String text) {
        this.text = text;
    }


    public Long getId() { return id; }
    public String getText() { return text; }


    public void setText(String text) {
        this.text = text;
    }
}

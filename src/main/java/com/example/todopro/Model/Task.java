package com.example.todopro.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "todo")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private boolean completed = false; // por defecto no completada
    private LocalDateTime completedAt; // opcional, fecha de completado


    public Task() {}

    public Task(String text) {
        this.text = text;
    }


    public Long getId() { return id; }
    public String getText() { return text; }
    public boolean isCompleted() { return completed; }
    public LocalDateTime getCompletedAt() { return completedAt; }


    public void setText(String text) {
        this.text = text;
    }


    public void toggleCompleted() {
        if (this.completed) {

            this.completed = false;
            this.completedAt = null;
        } else {

            this.completed = true;
            this.completedAt = LocalDateTime.now();
        }
    }
}

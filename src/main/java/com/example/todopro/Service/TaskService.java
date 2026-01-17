package com.example.todopro.Service;

import com.example.todopro.Model.Task;
import com.example.todopro.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<Task> getAll() {
        return repo.findAll();
    }

    public Task create(Task task) {
        return repo.save(task);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalStateException("La tarea no existe");
        }
        repo.deleteById(id);
    }

    public Task updateText(Long id, String text) {
        Task task = repo.findById(id)
                .orElseThrow(() -> new IllegalStateException("Tarea no encontrada"));

        task.setText(text);
        return repo.save(task);
    }


    public Task toggleCompleted(Long id) {
        Task task = repo.findById(id)
                .orElseThrow(() -> new IllegalStateException("Tarea no encontrada"));

        task.toggleCompleted();// acciódominion del
        return repo.save(task);
    }
}

package com.example.todopro.Controller;

import com.example.todopro.Model.Task;
import com.example.todopro.Service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://todopro-frontend.netlify.app/")
public class TodoController {

    private final TaskService service;

    public TodoController(TaskService service) {
        this.service = service;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return service.getAll();
    }

    @PostMapping("/tasks")
    public Task crearTarea(@RequestBody Task task) {
        return service.create(task);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(
            @PathVariable Long id,
            @RequestBody Task updatedTask) {
        return service.updateText(id, updatedTask.getText());
    }


    @PutMapping("/tasks/{id}/toggle")
    public Task toggleCompleted(@PathVariable Long id) {
        return service.toggleCompleted(id);
    }
}

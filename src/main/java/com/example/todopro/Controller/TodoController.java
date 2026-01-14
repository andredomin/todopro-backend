package com.example.todopro.Controller;
import com.example.todopro.Model.Task;
import com.example.todopro.Repository.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://todopro-frontend.netlify.app/")
public class TodoController {
    private final TaskRepository repo;
    public TodoController(TaskRepository repo) {
        this.repo = repo;
    }
    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return repo.findAll();
    }

    @PostMapping("/tasks")
    public Task crearTarea(@RequestBody Task task) {
        return repo.save(task);
    }
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        boolean exists = repo.existsById(id);
        if (!exists) {
            return ResponseEntity.notFound().build(); // 404 si no existe
        }

        repo.deleteById(id);
        return ResponseEntity.noContent().build(); // 204 No Content si eliminado
    }
    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable Long id,
            @RequestBody Task updatedTask) {

        return repo.findById(id)
                .map(task -> {
                    task.setText(updatedTask.getText());
                    Task saved = repo.save(task);
                    return ResponseEntity.ok(saved);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}

package com.example.todopro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.todopro.Model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}


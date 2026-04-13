package com.crm.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crm.project.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

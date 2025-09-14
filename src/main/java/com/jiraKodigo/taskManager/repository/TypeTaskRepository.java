package com.jiraKodigo.taskManager.repository;

import com.jiraKodigo.taskManager.models.tasks.taskTypes.TypeTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeTaskRepository extends JpaRepository<TypeTask, Long> {
}


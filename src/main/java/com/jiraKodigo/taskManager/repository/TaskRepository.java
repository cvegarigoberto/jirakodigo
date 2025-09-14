package com.jiraKodigo.taskManager.repository;

import com.jiraKodigo.taskManager.models.projects.Project;
import com.jiraKodigo.taskManager.models.tasks.MinionTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<MinionTask, Long> {

    List<MinionTask> findByProject(Project project);

}

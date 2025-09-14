package com.jiraKodigo.taskManager.repository;

import com.jiraKodigo.taskManager.models.projects.FighterProject;
import com.jiraKodigo.taskManager.models.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FighterProjectRepository extends JpaRepository<FighterProject, Long> {
    List<FighterProject> findByUsersContaining(User user);
}


package com.jiraKodigo.taskManager.repository;

import com.jiraKodigo.taskManager.models.users.role.RoleTypeTask;
import com.jiraKodigo.taskManager.models.users.role.RoleTypeTaskId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleTypeTaskRepository extends JpaRepository<RoleTypeTask, RoleTypeTaskId> {
    List<RoleTypeTask> findByRoleId(Long roleId);
}


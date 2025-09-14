package com.jiraKodigo.taskManager.services.taskService;

import com.jiraKodigo.taskManager.models.tasks.taskTypes.TypeTask;
import com.jiraKodigo.taskManager.models.users.role.RoleTypeTask;
import com.jiraKodigo.taskManager.repository.RoleTypeTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleTypeTaskService {

    @Autowired
    private RoleTypeTaskRepository roleTypeTaskRepository;

    public List<TypeTask> getAllowedTypesForRole(Long roleId) {
        return roleTypeTaskRepository.findByRoleId(roleId).stream()
                .map(RoleTypeTask::getTypeTask)
                .toList();
    }
}

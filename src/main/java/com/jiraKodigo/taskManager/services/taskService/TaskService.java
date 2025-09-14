package com.jiraKodigo.taskManager.services.taskService;

import com.jiraKodigo.taskManager.models.projects.FighterProject;
import com.jiraKodigo.taskManager.models.projects.Project;
import com.jiraKodigo.taskManager.models.tasks.MinionTask;
import com.jiraKodigo.taskManager.models.tasks.taskTypes.TypeTask;
import com.jiraKodigo.taskManager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private RoleTypeTaskService roleTypeTaskService;


    public MinionTask saveTask(MinionTask task) {
        return taskRepository.save(task);
    }

    public Optional<MinionTask> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<MinionTask> getTasksByProject(FighterProject project) {
        return taskRepository.findByProject(project);
    }

    public List<MinionTask> getVisibleTasksByProjectAndRole(Project project, Long roleId) {
        List<MinionTask> allTasks = taskRepository.findByProject(project);
        List<TypeTask> allowedTypes = roleTypeTaskService.getAllowedTypesForRole(roleId);

        Set<Long> allowedTypeIds = allowedTypes.stream()
                .map(TypeTask::getId)
                .collect(Collectors.toSet());

        return allTasks.stream()
                .filter(task -> task.getTypeTask() != null && allowedTypeIds.contains(task.getTypeTask().getId()))
                .toList();
    }

}
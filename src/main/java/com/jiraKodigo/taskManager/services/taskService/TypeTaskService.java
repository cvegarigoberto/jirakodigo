package com.jiraKodigo.taskManager.services.taskService;

import com.jiraKodigo.taskManager.models.tasks.taskTypes.TypeTask;
import com.jiraKodigo.taskManager.repository.TypeTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeTaskService {

    @Autowired
    private TypeTaskRepository typeTaskRepository;

    public List<TypeTask> getAllTypeTasks() {
        return typeTaskRepository.findAll();
    }

    public Optional<TypeTask> getTypeTaskById(Long id) {
        return typeTaskRepository.findById(id);
    }

    public TypeTask saveTypeTask(TypeTask typeTask) {
        return typeTaskRepository.save(typeTask);
    }
}

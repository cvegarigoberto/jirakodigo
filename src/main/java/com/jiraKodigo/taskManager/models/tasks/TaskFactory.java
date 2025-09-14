package com.jiraKodigo.taskManager.models.tasks;

import com.jiraKodigo.taskManager.models.tasks.taskStatus.Status;
import com.jiraKodigo.taskManager.models.tasks.taskTypes.TypeTask;

import java.util.Map;
import java.util.function.Function;

public class TaskFactory {
    private static final Map<String, Function<Map<String, String>, ITask>> taskMap = Map.of(
            "manual", TaskFactory::createManualTask
    );

    public static ITask getTask(String type, Map<String, String> data, Status status, TypeTask taskType) {
        Function<Map<String, String>, ITask> creator = taskMap.get(type.toLowerCase());
        if (creator == null) {
            throw new IllegalArgumentException("Tipo de tarea desconocido: " + type);
        }
        ITask task = creator.apply(data);
        task.setStatus(status);
        task.setType(taskType);
        return task;
    }

    private static ITask createManualTask(Map<String, String> data) {
        MinionTask task = new MinionTask();
        task.setTitle(data.get("title"));
        task.setDescription(data.get("description"));

        if (data.containsKey("comment")) {
            task.addComment(data.get("comment"));
        }

        return task;
    }

}

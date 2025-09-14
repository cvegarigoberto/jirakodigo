package com.jiraKodigo.taskManager.models.tasks;

import com.jiraKodigo.taskManager.models.tasks.taskStatus.Status;
import com.jiraKodigo.taskManager.models.tasks.taskTypes.TypeTask;

public interface ITask {
    String getTitle();
    void setTitle(String title);
    void addComment(String comment);
    void setStatus(Status status);
    Status getStatus();
    void setDescription(String description);
    String getDescription();
    TypeTask getTypeTask();
    void setType(TypeTask type);
}

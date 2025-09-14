package com.jiraKodigo.taskManager.models.projects;

public interface IProject {
    Long getId();
    void setId(Long id);

    String getName();
    void setName(String name);

    String getDescription();
    void setDescription(String description);

}

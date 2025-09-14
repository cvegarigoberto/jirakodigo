package com.jiraKodigo.taskManager.models.tasks;

import java.util.ArrayList;

import com.jiraKodigo.taskManager.models.projects.FighterProject;
import com.jiraKodigo.taskManager.models.tasks.taskStatus.Status;
import com.jiraKodigo.taskManager.models.tasks.taskTypes.TypeTask;
import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class MinionTask implements ITask{
    private String title;
    private ArrayList<String> comments;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    private String description;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private FighterProject project;

    @ManyToOne
    @JoinColumn(name = "type_task_id")
    private TypeTask typeTask;


    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void addComment(String comment) {
        comments.add(comment);
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public Status getStatus() {
        return this.status;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public TypeTask getTypeTask() {
        return this.typeTask;
    }

    @Override
    public void setType(TypeTask typeTask) {
        this.typeTask = typeTask;
    }
}

package com.jiraKodigo.taskManager.models.tasks.taskTypes;

import jakarta.persistence.*;

@Entity
@Table(name = "type_tasks")
public class TypeTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(nullable = false, unique = true)
    private String name;

    public TypeTask() {}

    public TypeTask(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

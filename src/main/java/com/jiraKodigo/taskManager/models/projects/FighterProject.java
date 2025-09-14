package com.jiraKodigo.taskManager.models.projects;

import com.jiraKodigo.taskManager.models.users.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "projects")
public class FighterProject extends Project{
    @ManyToMany
    @JoinTable(
            name = "user_projects",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getType() {
        return "Fighter";
    }

}

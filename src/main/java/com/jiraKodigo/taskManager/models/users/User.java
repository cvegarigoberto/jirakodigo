package com.jiraKodigo.taskManager.models.users;

import com.jiraKodigo.taskManager.models.projects.IProject;
import com.jiraKodigo.taskManager.models.projects.Project;
import com.jiraKodigo.taskManager.models.users.role.Fighter;
import com.jiraKodigo.taskManager.models.users.role.IRole;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User implements IUser{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Fighter rol;


    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String name) {
        this.password = password;
    }

    @Override
    public IRole getRole() {
        return rol;
    }

    @Override
    public void setRole(IRole userRole) {
        this.rol = (Fighter)userRole;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}

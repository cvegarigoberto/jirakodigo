package com.jiraKodigo.taskManager.models.users;

import com.jiraKodigo.taskManager.models.users.role.Admin;
import com.jiraKodigo.taskManager.models.users.role.IRole;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class AdminUser implements IUser{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Admin rol;
    private String jobTitle;

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
        this.rol = (Admin)userRole;
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

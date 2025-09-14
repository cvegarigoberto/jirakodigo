package com.jiraKodigo.taskManager.models.users.role;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Fighter implements IRole{
    private String roleName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long roleId;

    @Override
    public String getName() {
        return roleName;
    }

    @Override
    public void setName(String name) {
        this.roleName = name;
    }

    @Override
    public Long getId() {
        return this.roleId;
    }

    @Override
    public void setId(Long roleId) {
        this.roleId = roleId;
    }


}
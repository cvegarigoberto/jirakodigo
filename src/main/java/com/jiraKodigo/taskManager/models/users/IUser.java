package com.jiraKodigo.taskManager.models.users;


import com.jiraKodigo.taskManager.models.users.role.IRole;

public interface IUser {
    Long getId();
    void setId(Long id);
    String getUsername();
    void setUsername(String username);
    String getPassword();
    void setPassword(String name);
    IRole getRole();
    void setRole(IRole userRole);
}

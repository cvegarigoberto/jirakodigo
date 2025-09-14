package com.jiraKodigo.taskManager.models.users.role;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RoleTypeTaskId implements Serializable {
    private Long roleId;
    private Long typeTaskId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getTypeTaskId() {
        return typeTaskId;
    }

    public void setTypeTaskId(Long typeTaskId) {
        this.typeTaskId = typeTaskId;
    }
}


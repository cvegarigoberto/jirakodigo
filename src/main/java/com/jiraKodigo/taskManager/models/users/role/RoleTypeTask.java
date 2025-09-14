package com.jiraKodigo.taskManager.models.users.role;

import com.jiraKodigo.taskManager.models.tasks.taskTypes.TypeTask;
import jakarta.persistence.*;

@Entity
@Table(name = "role_type_task")
public class RoleTypeTask {

    @EmbeddedId
    private RoleTypeTaskId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("roleId")
    private Fighter role;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("typeTaskId")
    private TypeTask typeTask;

    public TypeTask getTypeTask() {
        return typeTask;
    }
}

package com.jiraKodigo.taskManager.models.users;

import java.util.Map;
import java.util.function.Function;
import com.jiraKodigo.taskManager.models.users.role.IRole;

public class UserFactory {
    private static Map<String, IRole> roles;

    private static final Map<String, Function<Map<String, String>, IUser>> userMap = Map.of(
            "user", UserFactory::createUser
    );

    public static IUser getUser(String type, Map<String, String> data) {
        Function<Map<String, String>, IUser> creator = userMap.get(type.toLowerCase());
        if (creator == null) {
            throw new IllegalArgumentException("Tipo de usuario desconocido: " + type);
        }
        return creator.apply(data);
    }

    private static IUser createUser(Map<String, String> data) {
        User user = new User();
        user.setUsername(data.get("name"));
        user.setId(Long.parseLong(data.get("id")));
        String roleType = data.get("roleType");
        IRole matchedRole = roles.get(roleType);
        if (matchedRole == null) {
            throw new IllegalArgumentException("Tipo de usuario desconocido: " + roleType);
        }
        user.setRole(matchedRole);
        return user;
    }

    public static void setRoles(Map<String, IRole> roleCatalog) {
        roles = roleCatalog;
    }

}

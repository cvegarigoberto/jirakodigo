package com.jiraKodigo.taskManager.models.users.role;

import java.util.Map;
import java.util.function.Function;

public class RoleFactory {
    private static final Map<String, Function<Map<String, String>, IRole>> roleMap = Map.of(
            "admin", RoleFactory::createAdmin,
            "boss", RoleFactory::createBoss,
            "minion", RoleFactory::createMinion,
            "fighter", RoleFactory::createFighter
    );

    public static IRole getRole(String type, Map<String, String> data) {
        Function<Map<String, String>, IRole> creator = roleMap.get(type.toLowerCase());
        if (creator == null) {
            throw new IllegalArgumentException("Tipo de rol desconocido: " + type);
        }
        return creator.apply(data);
    }


    private static IRole createAdmin(Map<String, String> data) {
        Admin admin = new Admin();
        admin.setName(data.get("name"));
        admin.setId(Long.parseLong(data.get("id")));
        return admin;
    }

    private static IRole createFighter(Map<String, String> data) {
        Fighter fighter = new Fighter();
        fighter.setName(data.get("name"));
        fighter.setId(Long.parseLong(data.get("id")));
        return fighter;
    }

    private static IRole createBoss(Map<String, String> data) {
        Boss boss = new Boss();
        boss.setName(data.get("name"));
        boss.setId(Long.parseLong(data.get("id")));
        return boss;
    }

    private static IRole createMinion(Map<String, String> data) {
        Minion minion = new Minion();
        minion.setName(data.get("name"));
        minion.setId(Long.parseLong(data.get("id")));
        return minion;
    }

}

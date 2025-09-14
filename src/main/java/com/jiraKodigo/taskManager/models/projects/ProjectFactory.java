package com.jiraKodigo.taskManager.models.projects;

import java.util.Map;
import java.util.function.Function;

public class ProjectFactory {
    private static final Map<String, Function<Map<String, String>, IProject>> projectMap = Map.of(
            "fighter", ProjectFactory::createFighterProject
    );

    public static IProject getProject(String type, Map<String, String> data) {
        Function<Map<String, String>, IProject> creator = projectMap.get(type.toLowerCase());
        if (creator == null) {
            throw new IllegalArgumentException("Tipo de proyecto desconocido: " + type);
        }
        return creator.apply(data);
    }

    private static IProject createFighterProject(Map<String, String> data) {
        FighterProject project = new FighterProject();
        project.setId(Long.parseLong(data.get("id")));
        project.setName(data.get("name"));
        project.setDescription(data.get("description"));
        return project;
    }
}

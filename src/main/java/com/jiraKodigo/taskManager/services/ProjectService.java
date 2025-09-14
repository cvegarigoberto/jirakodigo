package com.jiraKodigo.taskManager.services;

import com.jiraKodigo.taskManager.models.projects.FighterProject;
import com.jiraKodigo.taskManager.models.projects.IProject;
import com.jiraKodigo.taskManager.models.users.User;
import com.jiraKodigo.taskManager.repository.FighterProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private FighterProjectRepository fighterRepo;

    public List<FighterProject> getProjectsByUser(User user) {
        List<FighterProject> allProjects = new ArrayList<>();
        allProjects.addAll(fighterRepo.findByUsersContaining(user));
        return allProjects;
    }

    public Optional<FighterProject> findProjectById(Long id) {
        Optional<FighterProject> fighter = fighterRepo.findById(id);
        return Optional.of(fighter.get());
    }


}

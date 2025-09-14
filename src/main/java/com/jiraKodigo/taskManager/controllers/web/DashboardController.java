package com.jiraKodigo.taskManager.controllers.web;

import com.jiraKodigo.taskManager.models.projects.FighterProject;
import com.jiraKodigo.taskManager.models.projects.IProject;
import com.jiraKodigo.taskManager.models.users.User;
import com.jiraKodigo.taskManager.services.ProjectService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/dashboard")
    public String showDashboard(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedUser");

        if (user == null) {
            return "redirect:/login";
        }

        List<FighterProject> projects = projectService.getProjectsByUser(user);
        model.addAttribute("projects", projects);
        model.addAttribute("username", user.getUsername());

        return "dashboard";
    }
}

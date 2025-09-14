package com.jiraKodigo.taskManager.controllers.web.projectController;

import com.jiraKodigo.taskManager.models.projects.FighterProject;
import com.jiraKodigo.taskManager.models.tasks.MinionTask;
import com.jiraKodigo.taskManager.services.ProjectService;
import com.jiraKodigo.taskManager.services.taskService.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    public String showProjectDetail(@PathVariable Long id, Model model) {
        Optional<FighterProject> projectOpt = projectService.findProjectById(id);
        if (projectOpt.isEmpty()) {
            return "redirect:/dashboard";
        }

        FighterProject project = projectOpt.get();
        List<MinionTask> tasks = taskService.getTasksByProject(project);

        model.addAttribute("project", project);
        model.addAttribute("tasks", tasks);

        return "projectDetail";
    }
}


package com.jiraKodigo.taskManager.controllers.web.taskController;

import com.jiraKodigo.taskManager.models.projects.FighterProject;
import com.jiraKodigo.taskManager.models.tasks.MinionTask;
import com.jiraKodigo.taskManager.models.tasks.taskStatus.Status;
import com.jiraKodigo.taskManager.services.ProjectService;
import com.jiraKodigo.taskManager.services.taskService.TaskService;
import com.jiraKodigo.taskManager.services.taskService.TypeTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TypeTaskService typeTaskService;

    // Show form to create a new task for a project
    @GetMapping("/create/{projectId}")
    public String showCreateForm(@PathVariable Long projectId, Model model) {
        Optional<FighterProject> projectOpt = projectService.findProjectById(projectId);
        if (projectOpt.isEmpty()) {
            return "redirect:/dashboard";
        }

        model.addAttribute("project", projectOpt.get());
        model.addAttribute("task", new MinionTask());
        model.addAttribute("typeTasks", typeTaskService.getAllTypeTasks());
        model.addAttribute("statuses", Status.values());

        return "task-form";
    }
}

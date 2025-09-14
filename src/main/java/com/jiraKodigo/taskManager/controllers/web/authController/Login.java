package com.jiraKodigo.taskManager.controllers.web.authController;

import com.jiraKodigo.taskManager.models.projects.FighterProject;
import com.jiraKodigo.taskManager.models.projects.IProject;
import com.jiraKodigo.taskManager.models.users.User;
import com.jiraKodigo.taskManager.services.AuthService;
import com.jiraKodigo.taskManager.services.ProjectService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class Login{

    @Autowired
    private AuthService authService;
    @Autowired
    private ProjectService projectService;


    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }


    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               Model model,
                               HttpSession session) {

        boolean valid = authService.validateCredentials(username, password);

        if (valid) {
            model.addAttribute("username", username);

            Optional<User> userOpt = authService.getUserByUsername(username);
            User user = userOpt.get();

            List<FighterProject> proyectos = projectService.getProjectsByUser(user);
            model.addAttribute("projects", proyectos);
            session.setAttribute("loggedUser", user);

            return "dashboard";
        } else {
            model.addAttribute("error", "Credenciales inválidas");
            return "login";
        }
    }
}

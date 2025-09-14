package com.jiraKodigo.taskManager.controllers.api.authController;

import com.jiraKodigo.taskManager.models.auth.LoginRequest;
import com.jiraKodigo.taskManager.models.auth.LoginResponse;
import com.jiraKodigo.taskManager.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AuthApiController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        boolean valid = authService.validateCredentials(request.getUsername(), request.getPassword());

        if (valid) {
            return ResponseEntity.ok(new LoginResponse("Login exitoso"));
        } else {
            return ResponseEntity.status(401).body(new LoginResponse("Credenciales inválidas"));
        }
    }
}




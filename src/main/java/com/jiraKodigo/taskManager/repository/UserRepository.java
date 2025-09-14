package com.jiraKodigo.taskManager.repository;

import com.jiraKodigo.taskManager.models.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

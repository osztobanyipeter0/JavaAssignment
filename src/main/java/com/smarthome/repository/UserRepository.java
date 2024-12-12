package com.smarthome.repository;

import com.smarthome.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findById(UUID userId);
    Optional<User> findByUsername(String username);
}

package com.smarthome.repository;

import com.smarthome.model.Property;
import com.smarthome.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface PropertyRepository extends JpaRepository<Property, UUID> {
    boolean existsByUser(User user);
    Optional<Property> findByUser(User user);
}

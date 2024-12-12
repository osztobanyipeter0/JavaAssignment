package com.smarthome.repository;

import com.smarthome.model.Estimate;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface EstimateRepository extends JpaRepository<Estimate, UUID> {
}

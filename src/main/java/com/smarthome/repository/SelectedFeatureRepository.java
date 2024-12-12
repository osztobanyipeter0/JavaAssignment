package com.smarthome.repository;

import com.smarthome.model.SelectedFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SelectedFeatureRepository extends JpaRepository<SelectedFeature, UUID> {
}

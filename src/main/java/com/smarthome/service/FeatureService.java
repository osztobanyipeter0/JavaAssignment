package com.smarthome.service;

import com.smarthome.model.Feature;
import com.smarthome.repository.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FeatureService {

    @Autowired
    private FeatureRepository featureRepository;

    public Page<Feature> findAllPaginated(Pageable pageable) {
        return featureRepository.findAll(pageable);
    }

    public List<Feature> findAll() {
        return featureRepository.findAll();
    }

    public Feature findById(UUID id) {
        Optional<Feature> feature = featureRepository.findById(id);
        if (feature.isPresent()) {
            return feature.get();
        } else {
            throw new RuntimeException("Feature not found with id: " + id);
        }
    }
}

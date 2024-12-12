package com.smarthome.service;

import com.smarthome.model.SelectedFeature;
import com.smarthome.repository.SelectedFeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectedFeatureService {

    @Autowired
    private SelectedFeatureRepository selectedFeatureRepository;

    public SelectedFeature save(SelectedFeature selectedFeature) {
        return selectedFeatureRepository.save(selectedFeature);
    }

    public List<SelectedFeature> saveAll(List<SelectedFeature> selectedFeatures) {
        return selectedFeatureRepository.saveAll(selectedFeatures);
    }
}

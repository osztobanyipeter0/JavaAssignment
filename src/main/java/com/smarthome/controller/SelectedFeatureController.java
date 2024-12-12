package com.smarthome.controller;

import com.smarthome.model.SelectedFeature;
import com.smarthome.service.SelectedFeatureService;
import com.smarthome.service.PropertyService;
import com.smarthome.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/selected-features")
public class SelectedFeatureController {

    @Autowired
    private SelectedFeatureService selectedFeatureService;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private FeatureService featureService;

    @PostMapping
    public List<SelectedFeature> createSelectedFeatures(@RequestBody List<SelectedFeature> selectedFeatures) {
        for (SelectedFeature selectedFeature : selectedFeatures) {
            selectedFeature.setProperty(propertyService.findById(selectedFeature.getProperty().getId()));
            selectedFeature.setFeature(featureService.findById(selectedFeature.getFeature().getId()));
            selectedFeature.setQuantity(1);
            selectedFeatureService.save(selectedFeature);
        }
        return selectedFeatures;
    }
}

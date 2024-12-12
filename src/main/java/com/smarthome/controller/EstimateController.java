package com.smarthome.controller;

import com.smarthome.model.Estimate;
import com.smarthome.model.Feature;
import com.smarthome.model.Property;
import com.smarthome.model.User;
import com.smarthome.service.CostEstimationService;
import com.smarthome.service.FeatureService;
import com.smarthome.service.PropertyService;
import com.smarthome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/estimates")
public class EstimateController {

    @Autowired
    private CostEstimationService costEstimationService;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private UserService userService;

    @Autowired
    private FeatureService featureService;

    @PostMapping("/calculate")
    public BigDecimal calculateEstimate(@RequestBody Property property) {
        User user = userService.findById(property.getUser().getId());
        List<Feature> selectedFeatures = featureService.findAll();

        BigDecimal totalCost = costEstimationService.calculateTotalCost(property, selectedFeatures);

        return totalCost;
    }
}

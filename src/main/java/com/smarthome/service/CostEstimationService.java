package com.smarthome.service;

import com.smarthome.model.Estimate;
import com.smarthome.model.Feature;
import com.smarthome.model.Property;
import com.smarthome.model.User;
import com.smarthome.repository.EstimateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CostEstimationService {

    @Autowired
    private EstimateRepository estimateRepository;

    public BigDecimal calculateTotalCost(Property property, List<Feature> selectedFeatures) {
        BigDecimal totalCost = BigDecimal.ZERO;

        for (Feature feature : selectedFeatures) {
            if (feature.getId().equals(UUID.fromString("25a267ac-673d-44eb-865e-b4f32e8dd6cb"))) {
                totalCost = totalCost.add(feature.getBaseCost());
            }
            if (feature.getId().equals(UUID.fromString("ca284d02-0f0f-41b6-bc27-775584b7c7a6"))) {
                totalCost = totalCost.add(feature.getBaseCost().multiply(BigDecimal.valueOf(property.getRooms())));
                totalCost = totalCost.add(feature.getBaseCost().multiply(BigDecimal.valueOf(property.getLights())));
            }
            if (feature.getId().equals(UUID.fromString("3151075d-205c-4568-8f4a-21522d5fe50e"))) {
                totalCost = totalCost.add(feature.getBaseCost().multiply(BigDecimal.valueOf(property.getRooms())));
            }
            if (feature.getId().equals(UUID.fromString("dd24aab8-5e52-4641-b675-d39ecdb72ae4"))) {
                totalCost = totalCost.add(feature.getBaseCost().multiply(BigDecimal.valueOf(property.getWindows())));
            }
            if (feature.getId().equals(UUID.fromString("ac86a9f5-e1e4-4f34-9549-ab4b27012732"))) {
                totalCost = totalCost.add(feature.getBaseCost().multiply(BigDecimal.valueOf(property.getRadiators())));
            }
        }

        return totalCost;
    }

    public Estimate createEstimate(Property property, User user, BigDecimal totalCost) {
        Estimate estimate = new Estimate();
        estimate.setProperty(property);
        estimate.setUser(user);
        estimate.setTotalCost(totalCost);
        estimate.setCreatedAt(LocalDateTime.now());
        return estimateRepository.save(estimate);
    }
}

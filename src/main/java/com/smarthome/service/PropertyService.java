package com.smarthome.service;

import com.smarthome.model.Property;
import com.smarthome.model.User;
import com.smarthome.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public Property save(Property property) {
        return propertyRepository.save(property);
    }

    public boolean existsByUser(User user) {
        return propertyRepository.existsByUser(user);
    }

    public Property findByUser(User user) {
        return propertyRepository.findByUser(user).orElse(null);
    }

    public Property findById(UUID id) {
        Optional<Property> property = propertyRepository.findById(id);
        return property.orElse(null);
    }

    public void delete(UUID id) {
        propertyRepository.deleteById(id);
    }
}

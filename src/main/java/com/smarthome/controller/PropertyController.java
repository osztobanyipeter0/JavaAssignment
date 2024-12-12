package com.smarthome.controller;

import com.smarthome.model.Property;
import com.smarthome.model.User;
import com.smarthome.service.PropertyService;
import com.smarthome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private UserService userService;

    @PostMapping
    public Property createProperty(@RequestBody Property property) {
        User user = userService.findByUsername(property.getUser().getUsername());
        if (user == null) {
            throw new RuntimeException("User not found.");
        }
        if (propertyService.existsByUser(user)) {
            throw new RuntimeException("User already has a property calculation.");
        }
        property.setUser(user);
        property.setCreatedAt(LocalDateTime.now());
        return propertyService.save(property);
    }

    @PutMapping("/{id}")
    public Property updateProperty(@PathVariable UUID id, @RequestBody Property updatedProperty) {
        Property property = propertyService.findById(id);
        if (property == null) throw new RuntimeException("Property not found.");
        property.setRooms(updatedProperty.getRooms());
        property.setWindows(updatedProperty.getWindows());
        property.setRadiators(updatedProperty.getRadiators());
        property.setPrepared(updatedProperty.isPrepared());
        return propertyService.save(property);
    }

    @DeleteMapping("/{id}")
    public void deleteProperty(@PathVariable UUID id) {
        Property property = propertyService.findById(id);
        if (property == null) throw new RuntimeException("Property not found.");
        propertyService.delete(id);
    }

    @GetMapping("/user/{userId}")
    public Property getPropertyByUserId(@PathVariable UUID userId) {
        User user = userService.findById(userId);
        return propertyService.findByUser(user);
    }
}


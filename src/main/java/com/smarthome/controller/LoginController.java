package com.smarthome.controller;

import com.smarthome.model.User;
import com.smarthome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/auth")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/get-user-data")
    public User getUserData() {
        return getCurrentUser()
                .map(userService::findByUsername)
                .orElseThrow(() -> new AuthenticationCredentialsNotFoundException(null));
    }

    public static Optional<String> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return Optional.of(authentication.getName());
        }
        return Optional.empty();
    }

    @GetMapping(path = "/logout")
    public void logout() {
        SecurityContextHolder.clearContext();
    }
}

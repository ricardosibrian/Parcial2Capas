package com.example.prepractica.controllers;

import com.example.prepractica.domain.dtos.GeneralResponse;
import com.example.prepractica.domain.entities.User;
import com.example.prepractica.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestContoller {

    private final UserService userService;

    public TestContoller(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/whoami")
    public ResponseEntity<GeneralResponse> whoami() {
        User user = userService.findUserAuthenticated();
        String userEmail = user.getEmail();

        return GeneralResponse.getResponse(HttpStatus.OK, userEmail);
    }
}

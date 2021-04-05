package com.robosh.ejournal.controller;

import com.robosh.ejournal.data.entity.User;
import com.robosh.ejournal.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private final UserService userService;

    @GetMapping("/userlist")
    public List<User> getAllUsers() {
        return userService.getAll();
    }
}
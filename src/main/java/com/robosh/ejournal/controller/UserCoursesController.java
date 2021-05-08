package com.robosh.ejournal.controller;


import com.robosh.ejournal.data.entity.Course;
import com.robosh.ejournal.service.UserCoursesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mycourses")
@AllArgsConstructor
public class UserCoursesController {

    private final UserCoursesService userCoursesService;

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getUserStudyingCourses() {
        return new ResponseEntity<>(userCoursesService.getUserStudyingCourses(getUsername()), HttpStatus.OK);
    }

    private String getUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}

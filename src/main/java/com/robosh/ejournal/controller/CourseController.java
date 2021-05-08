package com.robosh.ejournal.controller;


import com.robosh.ejournal.data.entity.Course;
import com.robosh.ejournal.service.CourseService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/create")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        return new ResponseEntity<>(courseService.createCourse(course), HttpStatus.OK);
    }

    @GetMapping("/all")
    @ApiOperation("returns all courses where isVisible is true")
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/all-all")
    @ApiOperation("returns all all courses")
    public ResponseEntity<List<Course>> getAllAllCourses() {
        return new ResponseEntity<>(courseService.getAllAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/all-invisible")
    @ApiOperation("returns all courses where isVisible is false or null")
    public ResponseEntity<List<Course>> getInvisibleCourses() {
        return new ResponseEntity<>(courseService.getAllInvisibleCourses(), HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long courseId) {
        return new ResponseEntity<>(courseService.getCourseById(courseId), HttpStatus.OK);
    }
}

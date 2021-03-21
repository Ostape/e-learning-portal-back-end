package com.robosh.ejournal.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/test-endpoint")
public class TeacherController {

//    @ApiOperation("Save new teacher")
//    @PostMapping
//    public ResponseEntity<TeacherDto> saveTeacher(@RequestBody @Valid SaveTeacherDto teacher) {
//        return new ResponseEntity<>(teacherService.save(teacher), HttpStatus.CREATED);
//    }
//
    @ApiOperation("Get teacher by id")
    @GetMapping("/{id}")
    public String findTeacherById(@PathVariable Long id) {
        return "teacherService.findById(id);";
    }
}

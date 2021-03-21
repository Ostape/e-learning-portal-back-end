package com.robosh.ejournal.controller;

import com.robosh.ejournal.data.entity.User;
import com.robosh.ejournal.data.repository.TeacherRepository;
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

    private final TeacherRepository teacherRepository;

//    @ApiOperation("Save new teacher")
//    @PostMapping
//    public ResponseEntity<TeacherDto> saveTeacher(@RequestBody @Valid SaveTeacherDto teacher) {
//        return new ResponseEntity<>(teacherService.save(teacher), HttpStatus.CREATED);
//    }
//
    @ApiOperation("Create teacher by id")
    @GetMapping("/{id}")
    public String findTeacherById(@PathVariable Long id) {
        User user = new User();
        user.setFirstName("Name");
        teacherRepository.save(user);
        return "teacherService.findById(id);";
    }

    @ApiOperation("Get teacher by id")
    @GetMapping("/get/{id}")
    public String getTeacherById(@PathVariable Long id) {
        return teacherRepository.findAll().toString();
    }
}

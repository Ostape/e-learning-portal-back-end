package com.robosh.ejournal.controller;

import com.robosh.ejournal.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

//    @ApiOperation("Save new teacher")
//    @PostMapping
//    public ResponseEntity<TeacherDto> saveTeacher(@RequestBody @Valid SaveTeacherDto teacher) {
//        return new ResponseEntity<>(teacherService.save(teacher), HttpStatus.CREATED);
//    }
//
//    @ApiOperation("Get teacher by id")
//    @GetMapping("/{id}")
//    public TeacherDto findTeacherById(@PathVariable Long id) {
//        return teacherService.findById(id);
//    }
//
//    @ApiOperation("Get paged teachers by school id")
//    @GetMapping
//    public List<TeacherDto> findTeachersBySchoolId(
//            @RequestParam("page") int page,
//            @RequestParam("size") int size,
//            @RequestParam("schoolId") Long schoolId
//    ) {
//        return teacherService.findAllBySchoolId(schoolId, page, size);
//    }
//
//    @ApiOperation("Update teacher")
//    @PutMapping
//    public TeacherDto updateTeacher(@RequestBody @Valid SaveTeacherDto dto) {
//        return teacherService.updateTeacher(dto);
//    }
}

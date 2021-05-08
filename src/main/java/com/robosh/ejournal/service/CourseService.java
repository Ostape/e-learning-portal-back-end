package com.robosh.ejournal.service;


import com.robosh.ejournal.data.entity.Course;
import com.robosh.ejournal.data.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll().stream()
                .filter(course -> course.getIsVisibleCourse() != null && course.getIsVisibleCourse())
                .collect(Collectors.toList());
    }

    public List<Course> getAllInvisibleCourses() {
        return courseRepository.findAll().stream()
                .filter(course -> course.getIsVisibleCourse() == null || !course.getIsVisibleCourse())
                .collect(Collectors.toList());
    }

    public List<Course> getAllAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId).get();
    }
}

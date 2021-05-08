package com.robosh.ejournal.service;


import com.robosh.ejournal.data.entity.Course;
import com.robosh.ejournal.data.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }
}

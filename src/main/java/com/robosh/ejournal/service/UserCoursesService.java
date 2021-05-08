package com.robosh.ejournal.service;

import com.robosh.ejournal.data.entity.Course;
import com.robosh.ejournal.data.entity.UserCoursers;
import com.robosh.ejournal.data.repository.CourseRepository;
import com.robosh.ejournal.data.repository.UserCoursesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class UserCoursesService {

    private final UserCoursesRepository userCoursesRepository;
    private final CourseRepository courseRepository;

    public List<Course> getUserStudyingCourses(String username) {
        UserCoursers coursers = userCoursesRepository.findUserCoursersByUsername(username);
        if (coursers == null) {
            return Collections.emptyList();
        } else {
            return courseRepository.findAllById(coursers.getCoursesId());
        }
    }
}

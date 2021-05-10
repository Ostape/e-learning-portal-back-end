package com.robosh.ejournal.service;

import com.robosh.ejournal.data.entity.Course;
import com.robosh.ejournal.data.entity.User;
import com.robosh.ejournal.data.repository.CourseRepository;
import com.robosh.ejournal.data.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserCoursesService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public List<Course> getUserStudyingCourses(String username) {
        User user = userRepository.findUserByUsername(username);
        return courseRepository.findAllById(user.getSubscribedCoursesIds());
    }

    public List<Course> addCourseToStudy(String username, Long courseId) {
        User user = userRepository.findUserByUsername(username);
        user.getSubscribedCoursesIds().add(courseId);
        Course course = courseRepository.findById(courseId).get();
        course.getSubscribedUsers().add(user.getId());
        courseRepository.save(course);
        userRepository.save(user);
        return courseRepository.findAllById(user.getSubscribedCoursesIds());
    }
}

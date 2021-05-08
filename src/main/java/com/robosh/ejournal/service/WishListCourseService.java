package com.robosh.ejournal.service;

import com.robosh.ejournal.data.entity.Course;
import com.robosh.ejournal.data.entity.WishListCourses;
import com.robosh.ejournal.data.repository.CourseRepository;
import com.robosh.ejournal.data.repository.WishListCourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class WishListCourseService {

    private final WishListCourseRepository wishListCourseRepository;
    private final CourseRepository courseRepository;

    public List<Course> getCoursesByUsername(String username) {
        WishListCourses wishListCoursesByUsername = wishListCourseRepository.findWishListCoursesByUsername(username);
        if (wishListCoursesByUsername == null) {
            return Collections.emptyList();
        }
        return courseRepository.findAllById(wishListCoursesByUsername.getCoursesId());
    }

    public List<Course> addCourseToWishList(String username, Long courseId) {
        WishListCourses wishListCourses = wishListCourseRepository.findWishListCoursesByUsername(username);
        if (wishListCourses == null) {
            wishListCourses = new WishListCourses();
            wishListCourses.setCoursesId(new ArrayList<>());
            wishListCourses.setUsername(username);
        }
        wishListCourses.getCoursesId().add(courseId);
        wishListCourseRepository.save(wishListCourses);
        return getCoursesByIds(wishListCourses.getCoursesId());
    }

    private List<Course> getCoursesByIds(List<Long> coursesIds) {
        return courseRepository.findAllById(coursesIds);
    }

    public List<Course> deleteCourseFromWishList(String username, Long courseId) {
        WishListCourses wishListCourses = wishListCourseRepository.findWishListCoursesByUsername(username);
        wishListCourses.getCoursesId().remove(courseId);
        return courseRepository.findAllById(wishListCourseRepository.save(wishListCourses).getCoursesId());
    }
}

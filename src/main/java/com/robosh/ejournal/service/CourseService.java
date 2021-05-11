package com.robosh.ejournal.service;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.robosh.ejournal.data.entity.Course;
import com.robosh.ejournal.data.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
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

    public String uploadFile(MultipartFile file) {
        Map config = ObjectUtils.asMap(
                "cloud_name", "ddob6b7v0",
                "api_key", "184919645278932",
                "api_secret", "jnp-Mln7gO1rH4tVNvzWd0ASlnI");
        Cloudinary cloudinary = new Cloudinary(config);
        Map params = ObjectUtils.asMap(
                "public_id", "myfolder/" + file.getOriginalFilename(),
                "overwrite", true,
                "resource_type", "image"
        );
        Map up;
        try {
            up = cloudinary.uploader().upload(file.getBytes(), params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return (String)up.get("secure_url");
    }
}

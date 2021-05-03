package com.robosh.ejournal.data.repository;

import com.robosh.ejournal.data.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}

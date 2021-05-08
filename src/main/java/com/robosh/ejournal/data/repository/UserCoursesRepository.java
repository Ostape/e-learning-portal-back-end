package com.robosh.ejournal.data.repository;

import com.robosh.ejournal.data.entity.UserCoursers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCoursesRepository extends JpaRepository<UserCoursers, Long> {

    UserCoursers findUserCoursersByUsername(String username);
}

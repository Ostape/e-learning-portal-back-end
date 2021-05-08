package com.robosh.ejournal.data.repository;

import com.robosh.ejournal.data.entity.WishListCourses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListCourseRepository extends JpaRepository<WishListCourses, Long> {

    WishListCourses findWishListCoursesByUsername(String username);
}

package com.robosh.ejournal.controller;


import com.robosh.ejournal.data.entity.Course;
import com.robosh.ejournal.service.WishListCourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
@AllArgsConstructor
public class WishListCourseController {

    private final WishListCourseService wishListCourseService;

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getWishListCourses() {
        return new ResponseEntity<>(wishListCourseService.getCoursesByUsername(getUsername()), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<List<Course>> addCourseToWishList(@RequestBody Long courseId) {
        return new ResponseEntity<>(wishListCourseService.addCourseToWishList(getUsername(), courseId), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<List<Course>> deleteCourseFromWishList(@RequestBody Long courseId) {
        return new ResponseEntity<>(wishListCourseService.deleteCourseFromWishList(getUsername(), courseId), HttpStatus.OK);
    }

    private String getUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}

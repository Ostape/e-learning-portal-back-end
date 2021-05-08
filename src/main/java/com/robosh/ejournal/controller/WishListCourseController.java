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
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        wishListCourseService.getCoursesByUsername(username);
        return new ResponseEntity<>(wishListCourseService.getCoursesByUsername(username), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<List<Course>> addCourseToWishList(@RequestBody Long courseId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return new ResponseEntity<>(wishListCourseService.addCourseToWishList(username, courseId), HttpStatus.OK);
    }
}

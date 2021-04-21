package com.robosh.ejournal.controller;

import com.robosh.ejournal.data.dto.UserDto;
import com.robosh.ejournal.data.entity.User;
import com.robosh.ejournal.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{username}")
    public ResponseEntity<User> getByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @ApiOperation("Returns all user data")
    @GetMapping("/user-data")
    public ResponseEntity<UserDto> getUserData() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return new ResponseEntity<>(userService.findByUsernameToken(username), HttpStatus.OK);
    }

    @ApiOperation("Update all user data")
    @PutMapping("/update-user")
    public ResponseEntity<UserDto> updateUserData(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.updateUserData(userDto), HttpStatus.OK);
    }
}
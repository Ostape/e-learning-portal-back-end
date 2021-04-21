package com.robosh.ejournal.service;

import com.robosh.ejournal.data.dto.UserDto;
import com.robosh.ejournal.data.entity.User;

import java.util.List;

public interface UserService {
    User register(User user);

    List<User> getAll();

    User findByUsername(String username);

    UserDto findByUsernameToken(String username);

    UserDto updateUserData(UserDto userDto);
}
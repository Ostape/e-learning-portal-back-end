package com.robosh.ejournal.service;

import com.robosh.ejournal.data.entity.User;

import java.util.List;

public interface UserService {
    User register(User user);

    List<User> getAll();

    User findById(Long id);

    User findByUsername(String username);
}
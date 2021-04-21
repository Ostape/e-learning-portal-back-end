package com.robosh.ejournal.service.impl;

import com.robosh.ejournal.data.dto.UserDto;
import com.robosh.ejournal.data.entity.Role;
import com.robosh.ejournal.data.entity.Status;
import com.robosh.ejournal.data.entity.User;
import com.robosh.ejournal.data.mapper.UserMapper;
import com.robosh.ejournal.data.repository.UserRepository;
import com.robosh.ejournal.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public User register(User user) {
        user.setRole(Role.ROLE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(Status.ACTIVE);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public UserDto findByUsernameToken(String username) {
        return userMapper.fromUserToUserDto(findByUsername(username));
    }
}
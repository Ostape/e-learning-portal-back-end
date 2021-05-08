package com.robosh.ejournal.service;

import com.robosh.ejournal.data.dto.UserDto;
import com.robosh.ejournal.data.entity.Role;
import com.robosh.ejournal.data.entity.Status;
import com.robosh.ejournal.data.entity.User;
import com.robosh.ejournal.data.mapper.UserMapper;
import com.robosh.ejournal.data.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public User register(User user) {
        user.setRole(Role.ROLE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(Status.ACTIVE);
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public UserDto findByUsernameToken(String username) {
        return userMapper.fromUserToUserDto(findByUsername(username));
    }

    public UserDto updateUserData(UserDto userDto) {
        User userByUsername = userRepository.findUserByUsername(userDto.getUsername());
        userDto.setId(userByUsername.getId());
        return userMapper.fromUserToUserDto(userRepository.save(userMapper.fromUserDtoToUser(userDto)));
    }
}
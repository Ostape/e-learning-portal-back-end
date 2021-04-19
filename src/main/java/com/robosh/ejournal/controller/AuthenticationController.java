package com.robosh.ejournal.controller;

import com.robosh.ejournal.data.dto.AuthenticationRequestDto;
import com.robosh.ejournal.data.entity.User;
import com.robosh.ejournal.security.jwt.JwtTokenProvider;
import com.robosh.ejournal.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/auth/")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDto dto) {
        try {
            String username = dto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, dto.getPassword()));
            User user = userService.findByUsername(username);
            if(user == null) {
                throw new UsernameNotFoundException(username + " not found");
            }

            String token = jwtTokenProvider.createToken(username, user.getRole());

            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);

            return ResponseEntity.ok(response);
        }catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid creds");
        }
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User user) {
        AuthenticationRequestDto request = new AuthenticationRequestDto();
        request.setUsername(user.getUsername());
        request.setPassword(user.getPassword());
        userService.register(user);
        return login(request);
    }
}
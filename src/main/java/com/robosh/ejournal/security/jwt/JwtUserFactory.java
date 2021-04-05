package com.robosh.ejournal.security.jwt;

import com.robosh.ejournal.data.entity.Status;
import com.robosh.ejournal.data.entity.User;
import lombok.Data;

@Data
public final class JwtUserFactory {
    public static JwtUser create(User user) {
        return JwtUser.builder()
                .id(user.getId())
                .password(user.getPassword())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .enable(user.getStatus().equals(Status.ACTIVE))
                .build();
    }
}
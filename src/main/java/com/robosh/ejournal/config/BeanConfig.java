package com.robosh.ejournal.config;


import com.robosh.ejournal.util.PasswordGenerator;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static com.robosh.ejournal.constant.Constants.PASSWORD_LENGTH;

@Configuration
public class BeanConfig {

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

    @Bean
    public PasswordGenerator getPasswordGenerator() {
        return PasswordGenerator.builder()
                .isAllowChars(true)
                .isAllowNumber(true)
                .isAllowUpperLetters(true)
                .isAllowLowerLetters(true)
                .passwordLength(PASSWORD_LENGTH)
                .build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

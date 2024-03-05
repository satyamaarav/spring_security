package com.split.service;

import com.split.dto.SignIn;
import com.split.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto getUserByUserId(int userId);
    String signInUser(SignIn signIn);
}

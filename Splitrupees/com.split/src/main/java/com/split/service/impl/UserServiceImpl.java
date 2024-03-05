package com.split.service.impl;

import com.split.dto.SignIn;
import com.split.dto.UserDto;
import com.split.entity.User;
import com.split.exception.ResourceNotFoundException;
import com.split.repository.UserRepo;
import com.split.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = this.userRepo.save(user);
        userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }

    @Override
    public UserDto getUserByUserId(int userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()->
                new ResourceNotFoundException(userId));

        return this.modelMapper.map(user, UserDto.class);
    }

    @Override
    public String signInUser(SignIn signIn) {
        User user = this.userRepo.findByMobile(signIn.getMobile()).orElseThrow(()->
                new ResourceNotFoundException(signIn.getMobile()));

        return "Password wrong";
    }


}

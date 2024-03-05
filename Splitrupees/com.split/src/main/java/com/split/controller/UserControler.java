package com.split.controller;

import com.split.dto.SignIn;
import com.split.dto.UserDto;
import com.split.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/split")
@CrossOrigin
@SecurityRequirement(name = "bearerAuth")
public class UserControler {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int userId){
        UserDto userDto = this.userService.getUserByUserId(userId);
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }

    @PostMapping("/user/signIn")
    public ResponseEntity<String> signInUser(@RequestBody SignIn signIn){
        var message = this.userService.signInUser(signIn);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}

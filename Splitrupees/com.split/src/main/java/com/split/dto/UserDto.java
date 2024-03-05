package com.split.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    public int userId;
    public String fname;
    public String lname;
    public String mobile;
    public String email;
    public String password;
}

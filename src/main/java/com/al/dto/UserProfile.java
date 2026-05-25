package com.al.dto;

import com.al.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    
}
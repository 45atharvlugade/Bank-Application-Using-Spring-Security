package com.al.dto;

import com.al.entity.Role;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoggedInUser {

	private Long userId;
	
	private Role role;
	
}

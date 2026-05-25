package com.al.dto;

import com.al.entity.Account;
import com.al.entity.Role;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterUser {

	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String password;
	
	private String email;
	
	private Long mobile;
	
	private Role role;
	
	public String toString() {
		return "User is Registered";
	}
	
	
}

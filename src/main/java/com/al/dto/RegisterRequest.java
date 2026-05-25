package com.al.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

	private RegisterAccount account;
	
	private RegisterUser user;
}

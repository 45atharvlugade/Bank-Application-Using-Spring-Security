package com.al.service;

import com.al.dto.LoginUserWithEmail;
import com.al.dto.RegisterAccount;
import com.al.dto.RegisterUser;
import com.al.entity.User;

public interface IAuthService {

	public String registerUser(RegisterUser user,RegisterAccount account);
	
	public User loginUser(LoginUserWithEmail user) ;
	
}

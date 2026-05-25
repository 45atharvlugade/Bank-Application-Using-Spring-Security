package com.al.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.al.dto.LoginUserWithEmail;
import com.al.dto.RegisterRequest;
import com.al.dto.UserProfile;
import com.al.entity.User;
import com.al.service.IAuthService;

@RestController
@RequestMapping("/customer")
public class AuthController {

	@Autowired
	private IAuthService authService;
	
	@PostMapping("register")
	public ResponseEntity<?> register(@RequestBody RegisterRequest rr){
		String msg= authService.registerUser(rr.getUser(), rr.getAccount());
		System.out.println(rr.getUser().getFirstName());
		return new ResponseEntity<String>(msg,HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginUserWithEmail user){
		User user1=authService.loginUser(user);
		
		UserProfile profile=new UserProfile();
		BeanUtils.copyProperties(user1, profile);
		
		return new  ResponseEntity<UserProfile>(profile,HttpStatusCode.valueOf(200));
	}
	
	
}

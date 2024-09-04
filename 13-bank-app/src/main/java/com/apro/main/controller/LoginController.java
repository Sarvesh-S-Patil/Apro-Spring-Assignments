package com.apro.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apro.main.DTO.JwtAuthResponse;
import com.apro.main.DTO.LoginDTO;
import com.apro.main.DTO.RegistrationDTO;
import com.apro.main.entity.User;
import com.apro.main.service.AuthService;

@RestController
@RequestMapping("/api")
public class LoginController {
	@Autowired
	private AuthService authService;
	
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody RegistrationDTO registrationDTO){
		return ResponseEntity.ok(authService.register(registrationDTO));
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> login (@RequestBody LoginDTO loginDTO){
		String token = authService.login(loginDTO);
		JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
		jwtAuthResponse.setAccessToken(token);
		return ResponseEntity.ok(jwtAuthResponse);
		
	}
	
}

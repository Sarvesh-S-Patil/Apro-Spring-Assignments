package com.apro.main.service;

import com.apro.main.DTO.LoginDTO;
import com.apro.main.DTO.RegistrationDTO;
import com.apro.main.entity.User;

public interface AuthService {
	User register(RegistrationDTO registration);
	String login(LoginDTO loginDTO);
}

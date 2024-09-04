package com.apro.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.apro.main.DTO.LoginDTO;
import com.apro.main.DTO.RegistrationDTO;
import com.apro.main.entity.Role;
import com.apro.main.entity.User;
import com.apro.main.exception.UserApiException;
import com.apro.main.repository.RoleRepository;
import com.apro.main.repository.UserRepository;
import com.apro.main.security.JwtTokenProvider;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@AllArgsConstructor
@RequiredArgsConstructor

public class AuthServiceImpl  implements AuthService{
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	
	
	
	@Override
	public User register(RegistrationDTO registration) {
		// TODO Auto-generated method stub
		
		if(userRepo.existsByUserName(registration.getUsername())) {
			throw new UserApiException(HttpStatus.BAD_REQUEST,"User already exists");
		}
		
		User user = new User();
		user.setUserName(registration.getUsername());
		user.setPassword(passwordEncoder.encode(registration.getPassword()));
		
		List<Role> roles = new ArrayList<>();
		Role userRole = roleRepo.findByName(registration.getRole()).get();
		roles.add(userRole);
		user.setRoles(roles);
		return userRepo.save(user);
	}

	@Override
	public String login(LoginDTO loginDTO) {
		// TODO Auto-generated method stub
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),loginDTO.getPassword()));

			SecurityContextHolder.getContext().setAuthentication(authentication);
			String token = jwtTokenProvider.generateToken(authentication);
			return token;
			
		}
		catch( BadCredentialsException e) {
				throw new UserApiException(HttpStatus.NOT_FOUND,"Username or password is incorrect");
		}
		
	}

}

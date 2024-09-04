package com.apro.main.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.apro.main.security.JwtAuthenticationEntryPoint;
import com.apro.main.security.JwtAuthenticationFilter;
import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@EnableMethodSecurity
@Configuration
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SecurityConfig {
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private JwtAuthenticationFilter authenticationFilter;
	@Autowired
	private JwtAuthenticationEntryPoint authenticationEntryPoint;
	
	
	@Bean
	static PasswordEncoder encrypt() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	  AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
	    return configuration.getAuthenticationManager();
	 }
	
	@Bean
	  SecurityFilterChain filterChain(HttpSecurity http) throws Exception { 
	    http.csrf(csrf -> csrf.disable()).cors(withDefaults());
	    http.sessionManagement(session -> session.sessionCreationPolicy(STATELESS));
	    
	    http.authorizeHttpRequests(request -> request.requestMatchers("/api/register").permitAll());
	    http.authorizeHttpRequests(request -> request.requestMatchers("/api/login").permitAll());

	    http.authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.GET, "/studentapp/"));
	    http.authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.POST, "/studentapp/"));
	    http.authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.PUT, "/studentapp/"));
	    http.authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.DELETE, "/studentapp/"));
	    
	    http.authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.GET, "/app/**"));
	    http.authorizeHttpRequests(request -> request.requestMatchers(HttpMethod.GET, "/studentapp/"));
	    
	    http.exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntryPoint));
	    http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
	    http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
	    return http.build();
	}
	
}

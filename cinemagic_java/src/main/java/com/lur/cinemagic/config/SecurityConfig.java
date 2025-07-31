/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license Click
 * nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this
 * template
 */
package com.lur.cinemagic.config;

import com.lur.cinemagic.service.CustomUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author lur
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@AllArgsConstructor
public class SecurityConfig {

	private CustomUserDetailsService userDetailsService;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)
		throws Exception {
		http.csrf()
			.disable()
			.authorizeHttpRequests(auth -> {
				// Theather controller
				auth.requestMatchers(HttpMethod.POST, "/cinemagic/theather")
					.hasRole("ADMIN")
					.requestMatchers(HttpMethod.PUT, "cinemagic/theater")
					.hasRole("ADMIN")
					.requestMatchers(HttpMethod.DELETE, "cinemagic/theather/*")
					.hasRole("ADMIN")
					// Branch Controller
					.requestMatchers(HttpMethod.POST, "/cinemagic/branch")
					.hasRole("ADMIN")
					.requestMatchers(HttpMethod.PUT, "cinemagic/branch")
					.hasRole("ADMIN")
					.requestMatchers(HttpMethod.DELETE, "cinemagic/branch/*")
					.hasRole("ADMIN")
					// CinemaUser controller
					.requestMatchers(HttpMethod.GET, "cinemagic/user")
					.hasRole("ADMIN")
					.requestMatchers(HttpMethod.PUT, "cinemagic/user/profile")
					.hasRole("USER")
					.requestMatchers(HttpMethod.GET, "cinemagic/user/profile")
					.hasRole("USER")
					// Movie Controller
					.requestMatchers(HttpMethod.POST, "cinemagic/movie")
					.hasRole("ADMIN")
					.requestMatchers(HttpMethod.PUT, "cinemagic/movie")
					.hasRole("ADMIN")
					.requestMatchers(HttpMethod.DELETE, "cinemagic/movie/*")
					.hasRole("ADMIN")
					// Review Controller
					.requestMatchers(HttpMethod.POST, "cinemagic/review")
					.hasRole("USER")
					.requestMatchers(HttpMethod.PUT, "cinemagic/review")
					.hasRole("USER")
					.requestMatchers(HttpMethod.DELETE, "cinemagic/review/*")
					.hasRole("USER")
					// Show controller
					.requestMatchers(HttpMethod.POST, "cinemagic/show")
					.hasRole("ADMIN")
					.requestMatchers(HttpMethod.PUT, "cinemagic/show")
					.hasRole("ADMIN")
					.requestMatchers(HttpMethod.DELETE, "cinemagic/show/*")
					.hasRole("ADMIN")
					// Ticket controller
					.requestMatchers(HttpMethod.GET, "cinemagic/ticket")
					.hasRole("ADMIN")
					.requestMatchers(HttpMethod.DELETE, "cinemagic/ticket/*")
					.hasRole("ADMIN")
					.requestMatchers(HttpMethod.GET, "cinemagic/show/*/ticket")
					.hasRole("ADMIN")
					.requestMatchers(HttpMethod.GET, "cinemagic/ticket/*")
					.hasRole("USER")
					.requestMatchers(HttpMethod.POST, "cinemagic/ticket")
					.hasRole("USER")
					.anyRequest()
					.permitAll();
			})
			.formLogin(Customizer.withDefaults());
		return http.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http)
		throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class)
			.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder())
			.and()
			.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

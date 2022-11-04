package com.cognizant.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.cognizant.services.UserDetailsServiceImpl;

@SuppressWarnings("deprecation")
@EnableWebSecurity
@EnableWebMvc
@Configuration
public class UserConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	UserDetailsServiceImpl detailsServiceImpl;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(detailsServiceImpl).passwordEncoder(Encoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/user/**").authenticated()
		.antMatchers("/save").permitAll()
		.and().formLogin();
	}

	@Bean 
	public BCryptPasswordEncoder Encoder() {
		return new BCryptPasswordEncoder();
	}
}

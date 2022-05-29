package com.summitworks.disasterrecovery.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.summitworks.disasterrecovery.repositories.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	
//	@Autowired
//	UserService userService;
//	
//	
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.httpBasic()
//				.and()
//					.authorizeRequests()
//				.antMatchers("/login").permitAll()
//				.anyRequest().authenticated();
//	}
//	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
//	
//	@Bean
//	public DaoAuthenticationProvider authencationProvider()
//	{
//		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//		auth.setUserDetailsService(userService);
//		// you can add more servics here...
//		auth.setPasswordEncoder(passwordEncoder());
//		return auth;
//	}
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth)
//	{
//		auth.authenticationProvider(authencationProvider());
//	}
	
	
	
}

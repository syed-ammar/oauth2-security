package com.way2learnonline;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		 //PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		
		auth.inMemoryAuthentication()
		//.passwordEncoder(encoder)
		.withUser("siva").password("siva").roles("USER").and()
		.withUser("admin").password("admin").roles("ADMIN");
	}
	
	

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.formLogin();
		//http.antMatcher("/login/**").p;
		
		
		//http.authorizeRequests().antMatchers("/login**","/oauth/authorize**").permitAll();
		//http.csrf().disable();
		/* http.requestMatchers()
         .antMatchers("/login", "/oauth/authorize")
         .and()
         .authorizeRequests()
         .anyRequest()
         .authenticated()
         .and()
         .formLogin()
         .permitAll();*/
		http.authorizeRequests().anyRequest().permitAll().and().httpBasic();
	}
	
}

package com.jwtauthentication.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jwtauthentication.demo.helper.JwtUtil;
import com.jwtauthentication.demo.model.JwtRequest;
import com.jwtauthentication.demo.model.JwtResponse;
import com.jwtauthentication.demo.services.CustomUserDetailsService;

@RestController
public class JwtController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@RequestMapping(value="/token",method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		System.out.println(jwtRequest);
		   try {
			   this.authenticationManager.
			   authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(),jwtRequest.getPassWord()));
			 
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credential/User not found Exception ");
		}catch (BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Credential ");
		}
		
		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUserName());
		String tokan  = this.jwtUtil.generateToken(userDetails);
		
		System.out.println("JWT " + tokan);
		return ResponseEntity.ok(new JwtResponse(tokan));
		
	}

}

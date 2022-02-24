package com.jwtauthentication.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@GetMapping(path = "/hello/api")
	public String hellapi() {
		String text = "this is private page ";
		text 
		       +="\n This page is not allowed to unauthenticated users..";
		
		return text;
		
	}

}

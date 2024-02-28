package com.tsfn.Security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsfn.Security.service.AuthenticationRequest;
import com.tsfn.Security.service.AuthenticationResponse;
import com.tsfn.Security.service.AuthenticationService;
import com.tsfn.Security.service.RegisterationRequest;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationService service;

	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterationRequest request) {
		return ResponseEntity.ok(service.register(request));
	}

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authinticate(@RequestBody AuthenticationRequest request) {
		return ResponseEntity.ok(service.authinticate(request));
	}

}

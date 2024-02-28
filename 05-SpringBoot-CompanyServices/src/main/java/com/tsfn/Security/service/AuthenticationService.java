package com.tsfn.Security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.tsfn.Security.repos.UserRepository;

@Service
public class AuthenticationService {

	@Autowired
	private UserRepository UserRepo;

	public AuthenticationResponse register(RegisterationRequest request) {

		// Insert(request)
		UserDetails userDetails = UserRepo.findUserByEmail(request.getEmail());
		AuthenticationResponse authenticationResponse = new AuthenticationResponse();
		authenticationResponse.setToken(" TODO ");
		return authenticationResponse;
	}

	public AuthenticationResponse authinticate(AuthenticationRequest request) {
		// valid if user is exist in the system
		UserDetails user = UserRepo.findUserByEmail(request.getEmail());
		// check if this user has a valid token:return the token
		// else throw exception bad credential
		AuthenticationResponse authenticationResponse = new AuthenticationResponse();
		authenticationResponse.setToken("bring the valid token");
		return authenticationResponse;
	}

}

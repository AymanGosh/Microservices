package com.tsfn.Security.config;

import java.util.function.Function;

import io.jsonwebtoken.Claims;

// 19-2 = part 2 => 01:12 
public class JWTUtils {

	public String getTheUserEmail(String jwt) {
		// go and take just the email
		return extractClaim(jwt, Claims::getSubject);
	}

	private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
		Claims claims = extractAllClaims(token);
		return claimResolver.apply(claims);

	}

	private Claims extractAllClaims(String token) {
		// TODO Auto-generated method stub
		return null;
	}

}

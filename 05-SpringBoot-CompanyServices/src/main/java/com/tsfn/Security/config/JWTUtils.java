package com.tsfn.Security.config;

import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

// 19-2 = part 2 => 01:35 

public class JWTUtils {

	@Value("${com.jwt.secret}")
	private String jwtSigningKey;

	public String extractUserEmail(String jwt) {
		// go and take just the email
		return extractClaim(jwt, Claims::getSubject);
	}

	private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
		Claims claims = extractAllClaims(token);
		return claimResolver.apply(claims);

	}

	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(Base64.getEncoder().encode(jwtSigningKey.getBytes())).build()
				.parseClaimsJws(token).getBody();
	}

	public boolean isTokenValid(String token, UserDetails userDetails) {
		final String useremail = extractUserEmail(token);
		return (useremail.equals(userDetails.getUsername())) && !isTokenExpired(token);
	}

	private boolean isTokenExpired(String token) {
		return extractExpirationDate(token).before(new Date());
	}

	private Date extractExpirationDate(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

}

package com.tsfn.Security.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JWTUtils jwtUtils;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String authHeader = request.getHeader("Authorization");
		final String jwt;
		final String userEmail;
		if ((authHeader == null) || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		jwt = authHeader.substring(7);

		// fetch the email from the token
		userEmail = JWTUtils.getTheUserEmail(jwt);

//		if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//			UserDetails userDetails = userService.userDetailsService().loadUserByUsername(userEmail);
//			if (jwtService.isTokenValid(jwt, userDetails)) {
//				SecurityContext context = SecurityContextHolder.createEmptyContext();
//				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
//						null, userDetails.getAuthorities());
//				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//				context.setAuthentication(authToken);
//				SecurityContextHolder.setContext(context);
//			}
//		}
//		filterChain.doFilter(request, response);

	}

}

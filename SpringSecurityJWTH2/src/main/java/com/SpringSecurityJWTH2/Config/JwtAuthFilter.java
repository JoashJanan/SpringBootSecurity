package com.SpringSecurityJWTH2.Config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.SpringSecurityJWTH2.Service.CustomUserDetailsService;
import com.SpringSecurityJWTH2.Service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter{

	 private JwtService jwtService;
	    private CustomUserDetailsService userDetailsService;

	    public JwtAuthFilter(JwtService jwtService,
	                         CustomUserDetailsService userDetailsService) {
	        this.jwtService = jwtService;
	        this.userDetailsService = userDetailsService;
	    }
	    @Override
	    protected void doFilterInternal(HttpServletRequest request,
	                                    HttpServletResponse response,
	                                    FilterChain chain)
	    
	            throws ServletException, IOException {

	        String header = request.getHeader("Authorization");

	        if (header != null && header.startsWith("Bearer ")) {

	            String token = header.substring(7);
	            String username = jwtService.extractUsername(token);

	            if (username != null &&
	                SecurityContextHolder.getContext().getAuthentication() == null) {

	                UserDetails userDetails =
	                        userDetailsService.loadUserByUsername(username);

	                UsernamePasswordAuthenticationToken auth =
	                        new UsernamePasswordAuthenticationToken(
	                                userDetails, null,
	                                userDetails.getAuthorities());

	                SecurityContextHolder.getContext().setAuthentication(auth);
	            }
	        }

	        chain.doFilter(request, response);
	    }
}

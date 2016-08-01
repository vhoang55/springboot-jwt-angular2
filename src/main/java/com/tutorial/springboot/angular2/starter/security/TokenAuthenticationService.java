package com.tutorial.springboot.angular2.starter.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class TokenAuthenticationService {

    private static final String AUTH_HEADER_NAME = "x-auth-token";

    private final JwtTokenHandler jwtTokenHandler;

    @Autowired
    public TokenAuthenticationService(JwtTokenHandler jwtTokenHandler) {
        this.jwtTokenHandler = jwtTokenHandler;
    }

    public void addJwtTokenToHeader(HttpServletResponse response,
                             UserAuthentication authentication) {
        final UserDetails user = authentication.getDetails();
        response.addHeader(AUTH_HEADER_NAME, jwtTokenHandler.createTokenForUser(user));
    }

    public Authentication generateAuthenticationFromRequest(HttpServletRequest request) {
        final String token = request.getHeader(AUTH_HEADER_NAME);
        if (token == null || token.isEmpty()) return null;
        return jwtTokenHandler
                .parseUserFromToken(token)
                .map(UserAuthentication::new)
                .orElse(null);
    }
}

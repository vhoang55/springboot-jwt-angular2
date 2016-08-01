package com.tutorial.springboot.angular2.starter.security;

import com.tutorial.springboot.angular2.starter.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Optional;

@Component
public final class JwtTokenHandler {

    private final String secret;
    private final UserService userService;

    @Autowired
    public JwtTokenHandler(@Value("${app.blog.jwt.secret}") String secret, UserService userService) {
        this.secret = secret;
        this.userService = userService;
    }

    Optional<UserDetails> parseUserFromToken(String token) {
        String username = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return Optional.ofNullable(userService.loadUserByUsername(username));
    }

    public String createTokenForUser(UserDetails user) {
        final ZonedDateTime afterOneWeek = ZonedDateTime.now().plusWeeks(1);
        return Jwts.builder()
                .setSubject(user.getUsername())
                .signWith(SignatureAlgorithm.HS512, secret)
                .setExpiration(Date.from(afterOneWeek.toInstant()))
                .compact();
    }
}
package com.tutorial.springboot.angular2.starter.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.tutorial.springboot.angular2.starter.model.Role;
import com.tutorial.springboot.angular2.starter.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;


public final class UserDTO {

    private static final String ROLE_USER = "ROLE_USER";

    private final String email;
    @Size(min = 8, max = 100)
    private final String password;
    private final String name;

    public UserDTO(@JsonProperty("email") String email,
                   @JsonProperty("password") String password,
                   @JsonProperty("name") String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    public Optional<String> getEncodedPassword() {
        return Optional.ofNullable(password).map(p -> new BCryptPasswordEncoder().encode(p));
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public User toUser() {
        User user = new User();
        user.setUsername(email);
        user.setRole(new Role());
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        user.setName(name);
        return user;
    }

    public UsernamePasswordAuthenticationToken toAuthenticationToken() {
        return new UsernamePasswordAuthenticationToken(email, password, getAuthorities());
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(() -> ROLE_USER);
    }

}
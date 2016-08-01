package com.tutorial.springboot.angular2.starter.service;



import com.tutorial.springboot.angular2.starter.dto.UserDTO;
import com.tutorial.springboot.angular2.starter.model.User;

import java.util.Optional;

public interface UserService extends org.springframework.security.core.userdetails.UserDetailsService {

    User update(User user, UserDTO params);
    Optional<User> findUser(Long id);
    User createUser(UserDTO userDTO);

}
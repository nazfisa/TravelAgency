package com.agency.agency.service;

import com.agency.agency.dto.UserRegistrationDto;
import com.agency.agency.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author : agecny
 * @author : Nazim Uddin Asif
 * @since : 12/25/2020, Fri
 **/
public interface UserService extends UserDetailsService {
    List<User> findAll();

    User findById(Long id);

    User save(UserRegistrationDto user);

    void deleteById(Long id);

    User findByEmail(String email);
}

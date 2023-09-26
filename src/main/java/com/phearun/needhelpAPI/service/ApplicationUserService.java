package com.phearun.needhelpAPI.service;

import com.phearun.needhelpAPI.config.security.AuthUser;

import java.util.Optional;


public interface ApplicationUserService {
    Optional<AuthUser> loadUserByUsername(String username);

   // User save(User entity);
}

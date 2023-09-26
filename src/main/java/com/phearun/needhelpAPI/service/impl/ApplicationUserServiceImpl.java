/**
 * Author : PhearunPhin
 * Date : 9/20/2023
 */

package com.phearun.needhelpAPI.service.impl;

import com.phearun.needhelpAPI.config.security.AuthUser;
import com.phearun.needhelpAPI.exception.ApiException;
import com.phearun.needhelpAPI.mapper.UsersMapper;
import com.phearun.needhelpAPI.model.User;
import com.phearun.needhelpAPI.repository.UserRepository;
import com.phearun.needhelpAPI.service.ApplicationUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Primary
@Service
@RequiredArgsConstructor
public class ApplicationUserServiceImpl implements ApplicationUserService {
    private final UserRepository userRepository;

    @Override
    public Optional<AuthUser> loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST, "User not found %s".formatted(username)));
        AuthUser authUser = UsersMapper.INSTANCE.toAuthUser(user);
        authUser.setGrantedAuthorities(user.getRole().getAuthorities());
        return Optional.ofNullable(authUser);
    }



}

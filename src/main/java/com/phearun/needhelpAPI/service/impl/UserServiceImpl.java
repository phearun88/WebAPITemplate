/**
 * Author : PhearunPhin
 * Date : 9/20/2023
 */

package com.phearun.needhelpAPI.service.impl;

import com.phearun.needhelpAPI.model.User;
import com.phearun.needhelpAPI.repository.UserRepository;
import com.phearun.needhelpAPI.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository usersRepository;

    @Override
    public User save(User entity) {

        return usersRepository.save(entity);
    }


    @Override
    public List<User> getUsers() {
        return usersRepository.findAll();
    }
}


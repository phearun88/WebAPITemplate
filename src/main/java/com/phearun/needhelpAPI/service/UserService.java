package com.phearun.needhelpAPI.service;

import com.phearun.needhelpAPI.model.Category;
import com.phearun.needhelpAPI.model.User;

import java.util.List;

public interface UserService {
    User save(User entity);

    List<User> getUsers();
}

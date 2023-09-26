/**
 * Author : PhearunPhin
 * Date : 9/20/2023
 */

package com.phearun.needhelpAPI.controller;

import com.phearun.needhelpAPI.config.security.RoleEnum;
import com.phearun.needhelpAPI.dto.UsersDTO;
import com.phearun.needhelpAPI.mapper.UsersMapper;
import com.phearun.needhelpAPI.model.User;
import com.phearun.needhelpAPI.service.UserService;
import com.phearun.needhelpAPI.service.impl.ApplicationUserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;


    @PostMapping
    public ResponseEntity<User> create(@RequestBody UsersDTO usersDTO){

        User users = UsersMapper.INSTANCE.toEntity(usersDTO);

        users.setPassword(passwordEncoder.encode(users.getPassword()));

       // System.out.println("Role========"+ RoleEnum.EDITOR);

        users.setRole(RoleEnum.ADMIN);
        users.setIsAccountNonExpired(true);
        users.setIsCredentialsNonExpired(true);
        users.setIsAccountNonLocked(true);
        users.setIsEnabled(true);
      //  System.out.println(users.getPassword());

        users = userService.save(users);
        return ResponseEntity.ok(users);
    }
}

/**
 * Author : PhearunPhin
 * Date : 9/24/2023
 */

package com.phearun.needhelpAPI.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


public class UserServiceTest {
    public static void main(String[] args) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("test");
        System.out.println(encode);
    }
}

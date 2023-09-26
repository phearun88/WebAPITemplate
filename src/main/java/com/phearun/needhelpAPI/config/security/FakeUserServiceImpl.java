/**
 * Author : PhearunPhin
 * Date : 9/21/2023
 */

package com.phearun.needhelpAPI.config.security;

import com.phearun.needhelpAPI.service.ApplicationUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FakeUserServiceImpl implements ApplicationUserService {
    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<AuthUser> loadUserByUsername(String username) {
        return getAuthUsers().stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

    private List<AuthUser> getAuthUsers(){
        AuthUser dara = new AuthUser("mesa", passwordEncoder.encode("mesa"),RoleEnum.EDITOR.getAuthorities(),  true, true, true, true);
        AuthUser thida = new AuthUser("thida", passwordEncoder.encode("thida"),RoleEnum.ADMIN.getAuthorities(),  true, true, true, true);
        return List.of(dara, thida);
    }
}

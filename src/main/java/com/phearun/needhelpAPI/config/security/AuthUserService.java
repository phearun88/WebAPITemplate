/**
 * Author : PhearunPhin
 * Date : 9/21/2023
 */

package com.phearun.needhelpAPI.config.security;

import com.phearun.needhelpAPI.service.ApplicationUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthUserService implements UserDetailsService {
    private final ApplicationUserService applicationUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserService.loadUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User [%s] is not found".formatted(username)));
    }
}

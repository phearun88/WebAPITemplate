/**
 * Author : PhearunPhin
 * Date : 9/21/2023
 */

package com.phearun.needhelpAPI.config.security;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()

                .authorizeHttpRequests()
//                .antMatchers("/**").permitAll()
                .antMatchers("/swagger-ui/**").permitAll()
                //.antMatchers("/","/index","/home","css/**","js/**","/api/user").permitAll()
               // .antMatchers("/api/user").hasRole("ADMIN")


                .antMatchers(HttpMethod.POST, "/api/categories").hasAuthority(PermissionEnum.CATEGORY_WRITE.getDescription())
                .antMatchers(HttpMethod.GET, "/api/categories").hasAuthority(PermissionEnum.CATEGORY_READ.getDescription())
//                .anyRequest()
//                .authenticated()
                .and()
                .httpBasic();


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(getAuthenticationProvider());
    }

    @Bean
    public AuthenticationProvider getAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

    /*

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        //User dara = new User("dara", passwordEncoder.encode("dara123"), Collections.emptyList());

        UserDetails dara = User.builder()
                .username("dara")
                .password(passwordEncoder.encode("dara123"))
               // .roles("SALE") // ROLE_SALE
                .authorities(RoleEnum.EDITOR.getAuthorities())
                .build();

        UserDetails thida = User.builder()
                .username("thida")
                .password(passwordEncoder.encode("thida"))
                //.roles("ADMIN") // ROLE_ADMIN
                .authorities(RoleEnum.ADMIN.getAuthorities())
                .build();

        UserDetailsService detailsService = new InMemoryUserDetailsManager(dara, thida);
        return detailsService;
    }
   */

}

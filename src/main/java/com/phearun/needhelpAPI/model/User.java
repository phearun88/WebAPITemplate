/**
 * Author : PhearunPhin
 * Date : 9/6/2023
 */

package com.phearun.needhelpAPI.model;

import javax.persistence.*;

import com.phearun.needhelpAPI.config.security.RoleEnum;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastName;
    private String firstName;
    private String username;
    private String password;
    private Boolean isAccountNonExpired;
    private Boolean isAccountNonLocked;
    private Boolean isCredentialsNonExpired;
    private Boolean isEnabled;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    //@OneToMany
    //private Set<Role> roles;
}

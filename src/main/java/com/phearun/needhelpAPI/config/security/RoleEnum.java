package com.phearun.needhelpAPI.config.security;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.phearun.needhelpAPI.config.security.PermissionEnum.*;

@Getter
public enum RoleEnum {
    ADMIN(Set.of(CATEGORY_READ, CATEGORY_WRITE)),
    EDITOR(Set.of(CATEGORY_READ));

    private Set<PermissionEnum> permissions;

    private RoleEnum(Set<PermissionEnum> permissions) {
        this.permissions = permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities(){
        Set<SimpleGrantedAuthority> permissions = this.getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getDescription()))
                .collect(Collectors.toSet());

        SimpleGrantedAuthority role = new SimpleGrantedAuthority("ROLE_"+ this.name());
        permissions.add(role);

        return permissions;
    }
}

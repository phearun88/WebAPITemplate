package com.phearun.needhelpAPI.config.security;

import lombok.Getter;

@Getter
public enum PermissionEnum {
    CATEGORY_READ("category:read"), CATEGORY_WRITE("category:write");
    private String description;

    private PermissionEnum(String description){
        this.description = description;
    }
}

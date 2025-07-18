package org.example.enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    ROLE_BUYER,
    ROLE_SELLER;

    @Override
    public String getAuthority() {
        return name();
    }
}
package com.naijagis4me.v1.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;

public enum Roles {
    SUPERADMIN, ADMIN, USER;

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        java.util.Set<org.springframework.security.core.authority.SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new org.springframework.security.core.authority.SimpleGrantedAuthority(this.name()));
//        authorities.add(new SimpleGrantedAuthority(this.name()));
        return authorities;
    }

}

package com.boot.security.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class User implements UserDetails, Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long id;

    private String username;

    private String password;
    
    private List<Role> authorities;
    
    @Override
    public List<Role> getAuthorities() {
        return authorities;
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    @Override
    public boolean isEnabled() {
        return true;
    }
}
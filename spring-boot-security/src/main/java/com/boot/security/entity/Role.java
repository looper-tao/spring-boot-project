package com.boot.security.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

@Setter
@Getter
public class Role implements GrantedAuthority,Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long id;

    private String name;

    
    @Override
    public String getAuthority() {
        return name;
    }
}
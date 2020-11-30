package com.mxs.factory.security;

import com.mxs.model.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> grantedAuthorities;

    public static Optional<CustomUserDetails> fromUserModelToCustomUserDetails(final Optional<UserModel> userModelOptional) {

        return userModelOptional.map(userModel -> {
                    CustomUserDetails customUserDetails = new CustomUserDetails();
                    customUserDetails.username = userModel.getUsername();
                    customUserDetails.password = userModel.getPassword();
                    customUserDetails.grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(""));
                    return customUserDetails;
                }
        );
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
package com.mxs.factory.security;

import com.mxs.facade.UserFacade;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private UserFacade userFacade;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        return null;
    }
}
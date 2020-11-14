package com.mxs.domain.user.converter;

import com.mxs.domain.user.filter.LoginFilter;
import com.mxs.factory.converter.FilterConverterFactory;
import com.mxs.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public final class LoginFilterConverter implements FilterConverterFactory<LoginFilter, UserModel> {
    @Override
    public Optional<UserModel> convertToModel(final LoginFilter loginFilter) {
        return Optional.of(
                new UserModel
                        .Builder()
                        .username(Optional.ofNullable(loginFilter.getUsername()).orElse(null))
                        .email(Optional.ofNullable(loginFilter.getPassword()).orElse(null))
                        .build());
    }
}
package com.mxs.domain.user.converter;

import com.mxs.domain.user.filter.UserFilter;
import com.mxs.factory.converter.FilterConverterFactory;
import com.mxs.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public final class UserFilterConverter implements FilterConverterFactory<UserFilter, UserModel> {
    @Override
    public Optional<UserModel> convertToModel(final UserFilter userFilter) {
        return Optional.of(
                new UserModel.
                        Builder().
                        username(userFilter.getUsername()).
                        email(userFilter.getEmail()).
                        password(userFilter.getPassword()).
                        build());
    }
}
package com.mxs.converter;

import com.mxs.factory.FilterConverterFactory;
import com.mxs.filter.UserFilter;
import com.mxs.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public final class UserFilterConverter implements FilterConverterFactory<UserFilter, UserModel> {
    @Override
    public Optional<UserModel> convertToModel(final UserFilter userFilter) {
        return Optional.of(
                new UserModel(
                        userFilter.getUsername(),
                        userFilter.getEmail(),
                        userFilter.getPassword()));
    }
}
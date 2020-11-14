package com.mxs.domain.user.converter;

import com.mxs.domain.user.filter.ChangePasswordFilter;
import com.mxs.factory.converter.FilterConverterFactory;
import com.mxs.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public final class ChangePasswordConverter implements FilterConverterFactory<ChangePasswordFilter, UserModel> {

    @Override
    public Optional<UserModel> convertToModel(final ChangePasswordFilter changePasswordFilter) {
        return Optional.of(
                new UserModel
                        .Builder()
                        .username(Optional.ofNullable(changePasswordFilter.getUsername()).orElse(null))
                        .email(Optional.ofNullable(changePasswordFilter.getEmail()).orElse(null))
                        .password(Optional.ofNullable(changePasswordFilter.getPassword()).orElse(null))
                        .build());
    }
}

package com.mxs.domain.user.converter;

import com.mxs.domain.user.dto.ChangePasswordDto;
import com.mxs.factory.converter.FilterConverterFactory;
import com.mxs.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public final class ChangePasswordConverter implements FilterConverterFactory<ChangePasswordDto, UserModel> {

    @Override
    public Optional<UserModel> convertToModel(final ChangePasswordDto changePasswordDto) {
        return Optional.of(
                new UserModel
                        .Builder()
                        .username(Optional.ofNullable(changePasswordDto.getUsername()).orElse(null))
                        .email(Optional.ofNullable(changePasswordDto.getEmail()).orElse(null))
                        .password(Optional.ofNullable(changePasswordDto.getPassword()).orElse(null))
                        .build());
    }
}

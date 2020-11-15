package com.mxs.domain.user.converter;

import com.mxs.domain.user.dto.LoginDto;
import com.mxs.factory.converter.FilterConverterFactory;
import com.mxs.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public final class LoginConverter implements FilterConverterFactory<LoginDto, UserModel> {
    @Override
    public Optional<UserModel> convertToModel(final LoginDto loginDto) {
        return Optional.of(
                new UserModel
                        .Builder()
                        .username(Optional.ofNullable(loginDto.getUsername()).orElse(null))
                        .password(Optional.ofNullable(loginDto.getPassword()).orElse(null))
                        .build());
    }
}
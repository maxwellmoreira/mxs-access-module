package com.mxs.domain.access.converter;

import com.mxs.dto.LoginDto;
import com.mxs.factory.converter.ConverterFactory;
import com.mxs.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public final class LoginConverter implements ConverterFactory<LoginDto, UserModel> {
    @Override
    public LoginDto convertToDto(Optional<UserModel> userModelOptional) {
        return null;
    }

    @Override
    public Optional<UserModel> convertToModel(final LoginDto loginDto) {
        return Optional.of(
                new UserModel
                        .Builder()
                        .username(Optional.ofNullable(loginDto.getUsername()).orElse(null))
                        .password(Optional.ofNullable(loginDto.getPassword()).orElse(null))
                        .build());
    }

    @Override
    public List<LoginDto> convertToDtoList(final List<Optional<UserModel>> userModelOptionalList) {
        return null;
    }

    @Override
    public List<Optional<UserModel>> convertToModelList(final List<LoginDto> loginDtoList) {
        return null;
    }
}
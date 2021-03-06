package com.mxs.domain.access.converter;

import com.mxs.dto.RegisterDto;
import com.mxs.factory.converter.ConverterFactory;
import com.mxs.model.UserModel;

import java.util.List;

public final class RegisterConverter implements ConverterFactory<RegisterDto, UserModel> {
    @Override
    public RegisterDto convertToDto(final UserModel userModel) {
        return null;
    }

    @Override
    public UserModel convertToModel(final RegisterDto registerDto) {
        return new UserModel
                .Builder()
                .username(registerDto.getUsername())
                .email(registerDto.getEmail())
                .password(registerDto.getPassword())
                .build();
    }

    @Override
    public List<RegisterDto> convertToDtoList(final List<UserModel> userModelList) {
        return null;
    }

    @Override
    public List<UserModel> convertToModelList(final List<RegisterDto> registerDtoList) {
        return null;
    }
}
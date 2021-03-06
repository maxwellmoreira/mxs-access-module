package com.mxs.domain.access.converter;

import com.mxs.dto.LoginDto;
import com.mxs.factory.converter.ConverterFactory;
import com.mxs.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public final class LoginConverter implements ConverterFactory<LoginDto, UserModel> {
    @Override
    public LoginDto convertToDto(UserModel userModel) {
        return null;
    }

    @Override
    public UserModel convertToModel(final LoginDto loginDto) {
        return new UserModel
                .Builder()
                .username(loginDto.getUsername())
                .password(loginDto.getPassword())
                .build();
    }

    @Override
    public List<LoginDto> convertToDtoList(final List<UserModel> userModelList) {
        return null;
    }

    @Override
    public List<UserModel> convertToModelList(final List<LoginDto> loginDtoList) {
        return null;
    }
}
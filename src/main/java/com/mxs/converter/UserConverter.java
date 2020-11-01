package com.mxs.converter;

import com.mxs.dto.UserDto;
import com.mxs.factory.ConverterFactory;
import com.mxs.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public final class UserConverter implements ConverterFactory<UserDto, UserModel> {

    @Override
    public UserDto convertToDto(final UserModel userModel) {
        return new UserDto(
                userModel.getUsername(),
                userModel.getEmail(),
                userModel.getPassword());
    }

    @Override
    public UserModel convertToModel(final UserDto userDto) {
        return new UserModel(
                userDto.getUsername(),
                userDto.getEmail(),
                userDto.getPassword());
    }
}
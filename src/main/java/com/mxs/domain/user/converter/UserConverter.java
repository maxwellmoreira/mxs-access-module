package com.mxs.domain.user.converter;

import com.mxs.dto.UserDto;
import com.mxs.factory.converter.ConverterFactory;
import com.mxs.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public final class UserConverter implements ConverterFactory<UserDto, UserModel> {

    @Override
    public UserDto convertToDto(final UserModel userModel) {
        return new UserDto
                .Builder()
                .username(userModel.getUsername())
                .email(userModel.getEmail())
                .password(userModel.getPassword())
                .status(userModel.getStatusType().getCode())
                .build();
    }

    @Override
    public UserModel convertToModel(final UserDto userDto) {
        return new UserModel.
                Builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .status(userDto.getStatus())
                .build();
    }

    @Override
    public List<UserDto> convertToDtoList(final List<UserModel> userModelList) {
        return userModelList
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserModel> convertToModelList(final List<UserDto> userDtoList) {
        return userDtoList.stream().map(this::convertToModel).collect(Collectors.toList());
    }
}
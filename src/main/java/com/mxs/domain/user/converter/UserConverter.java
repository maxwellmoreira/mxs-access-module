package com.mxs.domain.user.converter;

import com.mxs.domain.user.dto.UserDto;
import com.mxs.factory.converter.ConverterFactory;
import com.mxs.factory.type.StatusType;
import com.mxs.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public final class UserConverter implements ConverterFactory<UserDto, UserModel> {

    @Override
    public UserDto convertToDto(final Optional<UserModel> userModelOptional) {
        return new UserDto
                .Builder()
                .username(userModelOptional.map(UserModel::getUsername).orElse(null))
                .email(userModelOptional.map(UserModel::getEmail).orElse(null))
                .password(userModelOptional.map(UserModel::getPassword).orElse(null))
                .status(userModelOptional.map(UserModel::getStatusType).map(StatusType::getCode).orElse(null))
                .build();
    }

    @Override
    public Optional<UserModel> convertToModel(final UserDto userDto) {
        return Optional.of(
                new UserModel.
                        Builder().
                        username(Optional.ofNullable(userDto.getUsername()).orElse(null)).
                        email(Optional.ofNullable(userDto.getEmail()).orElse(null)).
                        password(Optional.ofNullable(userDto.getPassword()).orElse(null)).
                        status(Optional.ofNullable(userDto.getStatus()).orElse(null)).
                        build());
    }

    @Override
    public List<UserDto> convertToDtoList(final List<Optional<UserModel>> userModelOptionalList) {
        return userModelOptionalList
                .stream()
                .map(model -> convertToDto(model))
                .collect(Collectors.toList());
    }

    @Override
    public List<Optional<UserModel>> convertToModelList(final List<UserDto> userDtoList) {
        return userDtoList
                .stream()
                .map(dto -> convertToModel(dto))
                .collect(Collectors.toList());
    }
}
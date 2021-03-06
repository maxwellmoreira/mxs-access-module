package com.mxs.domain.access.converter;

import com.mxs.dto.ChangePasswordDto;
import com.mxs.factory.converter.ConverterFactory;
import com.mxs.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public final class ChangePasswordConverter implements ConverterFactory<ChangePasswordDto, UserModel> {

    @Override
    public ChangePasswordDto convertToDto(UserModel userModel) {
        return null;
    }

    @Override
    public UserModel convertToModel(final ChangePasswordDto changePasswordDto) {
        return new UserModel
                .Builder()
                .username(changePasswordDto.getUsername())
                .email(changePasswordDto.getEmail())
                .password(changePasswordDto.getPassword())
                .build();
    }

    @Override
    public List<ChangePasswordDto> convertToDtoList(List<UserModel> userModelList) {
        return null;
    }

    @Override
    public List<UserModel> convertToModelList(List<ChangePasswordDto> changePasswordDtoList) {
        return null;
    }
}
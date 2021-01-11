package com.mxs.domain.access.converter;

import com.mxs.dto.ChangePasswordDto;
import com.mxs.factory.converter.ConverterFactory;
import com.mxs.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public final class ChangePasswordConverter implements ConverterFactory<ChangePasswordDto, UserModel> {

    @Override
    public ChangePasswordDto convertToDto(Optional<UserModel> userModelOptional) {
        return null;
    }

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

    @Override
    public List<ChangePasswordDto> convertToDtoList(List<Optional<UserModel>> modelOptionalList) {
        return null;
    }

    @Override
    public List<Optional<UserModel>> convertToModelList(List<ChangePasswordDto> changePasswordDtos) {
        return null;
    }
}

package com.mxs.domain.access.converter;

import com.mxs.dto.RecoverAccessDto;
import com.mxs.factory.converter.ConverterFactory;
import com.mxs.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecoverAccessConverter implements ConverterFactory<RecoverAccessDto, UserModel> {
    @Override
    public RecoverAccessDto convertToDto(final UserModel userModel) {
        return null;
    }

    @Override
    public UserModel convertToModel(final RecoverAccessDto recoverAccessDto) {
        return new UserModel
                .Builder()
                .username(recoverAccessDto.getUsername())
                .email(recoverAccessDto.getEmail())
                .build();
    }

    @Override
    public List<RecoverAccessDto> convertToDtoList(final List<UserModel> userModelList) {
        return null;
    }

    @Override
    public List<UserModel> convertToModelList(final List<RecoverAccessDto> recoverAccessDtos) {
        return null;
    }
}
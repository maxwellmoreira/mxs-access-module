package com.mxs.domain.access.converter;

import com.mxs.dto.RecoverAccessDto;
import com.mxs.factory.converter.ConverterFactory;
import com.mxs.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RecoverAccessConverter implements ConverterFactory<RecoverAccessDto, UserModel> {
    @Override
    public RecoverAccessDto convertToDto(final Optional<UserModel> userModelOptional) {
        return null;
    }

    @Override
    public Optional<UserModel> convertToModel(final RecoverAccessDto recoverAccessDto) {
        return Optional.of(
                new UserModel
                        .Builder()
                        .username(Optional.ofNullable(recoverAccessDto.getUsername()).orElse(null))
                        .email(Optional.ofNullable(recoverAccessDto.getEmail()).orElse(null))
                        .build());
    }

    @Override
    public List<RecoverAccessDto> convertToDtoList(final List<Optional<UserModel>> modelOptionalList) {
        return null;
    }

    @Override
    public List<Optional<UserModel>> convertToModelList(final List<RecoverAccessDto> recoverAccessDtos) {
        return null;
    }
}
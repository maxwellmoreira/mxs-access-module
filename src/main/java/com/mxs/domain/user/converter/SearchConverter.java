package com.mxs.domain.user.converter;

import com.mxs.dto.SearchDto;
import com.mxs.factory.converter.ConverterFactory;
import com.mxs.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public final class SearchConverter implements ConverterFactory<SearchDto, UserModel> {
    @Override
    public SearchDto convertToDto(final Optional<UserModel> userModelOptional) {
        return null;
    }

    @Override
    public Optional<UserModel> convertToModel(final SearchDto searchDto) {
        return Optional.of(
                new UserModel
                        .Builder()
                        .username(Optional.ofNullable(searchDto.getUsername()).orElse(null))
                        .email(Optional.ofNullable(searchDto.getEmail()).orElse(null))
                        .status(Optional.ofNullable(searchDto.getStatus()).orElse(null))
                        .build());
    }

    @Override
    public List<SearchDto> convertToDtoList(final List<Optional<UserModel>> userModelOptionalList) {
        return null;
    }

    @Override
    public List<Optional<UserModel>> convertToModelList(final List<SearchDto> searchDtoList) {
        return null;
    }
}
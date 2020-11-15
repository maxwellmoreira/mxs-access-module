package com.mxs.domain.user.converter;

import com.mxs.domain.user.dto.SearchDto;
import com.mxs.factory.converter.FilterConverterFactory;
import com.mxs.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public final class SearchConverter implements FilterConverterFactory<SearchDto, UserModel> {
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
}
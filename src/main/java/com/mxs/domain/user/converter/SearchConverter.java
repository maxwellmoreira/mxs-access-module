package com.mxs.domain.user.converter;

import com.mxs.dto.SearchDto;
import com.mxs.factory.converter.ConverterFactory;
import com.mxs.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public final class SearchConverter implements ConverterFactory<SearchDto, UserModel> {

    @Override
    public SearchDto convertToDto(final UserModel userModel) {
        return null;
    }

    @Override
    public UserModel convertToModel(final SearchDto searchDto) {
        return new UserModel
                .Builder()
                .username(searchDto.getUsername())
                .email(searchDto.getEmail())
                .status(searchDto.getStatus())
                .build();
    }

    @Override
    public List<SearchDto> convertToDtoList(final List<UserModel> userModelList) {
        return null;
    }

    @Override
    public List<UserModel> convertToModelList(final List<SearchDto> searchDtoList) {
        return null;
    }
}
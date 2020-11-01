package com.mxs.converter;

import com.mxs.factory.ConverterFactory;
import com.mxs.filter.UserFilter;
import com.mxs.model.UserModel;

import java.util.List;
import java.util.Optional;

public class UserFilterConverter implements ConverterFactory<UserFilter, UserModel> {

    @Override
    public UserFilter convertToDto(final Optional<UserModel> userModelOptional) {
        return null;
    }

    @Override
    public Optional<UserModel> convertToModel(final UserFilter userFilter) {
        return Optional.empty();
    }

    @Override
    public List<UserFilter> convertToDtoList(final List<Optional<UserModel>> modelOptionalList) {
        return null;
    }

    @Override
    public List<Optional<UserModel>> convertToModelList(final List<UserFilter> userFilters) {
        return null;
    }
}
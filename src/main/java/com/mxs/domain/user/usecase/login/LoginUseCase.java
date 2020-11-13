package com.mxs.domain.user.usecase.login;

import com.mxs.model.UserModel;

import java.util.Optional;

public interface LoginUseCase {
    public Optional<UserModel> login(final Optional<UserModel> userModelOptional);
}
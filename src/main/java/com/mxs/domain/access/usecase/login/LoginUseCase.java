package com.mxs.domain.access.usecase.login;

import com.mxs.model.UserModel;

public interface LoginUseCase {
    UserModel login(final UserModel userModel);
}
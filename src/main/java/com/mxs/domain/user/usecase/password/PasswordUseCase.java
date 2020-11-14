package com.mxs.domain.user.usecase.password;

import com.mxs.model.UserModel;

import java.util.Optional;

public interface PasswordUseCase {
    public void changePassword(final Optional<UserModel> userModelOptional);
}

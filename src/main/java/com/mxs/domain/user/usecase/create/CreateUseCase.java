package com.mxs.domain.user.usecase.create;

import com.mxs.model.UserModel;

public interface CreateUseCase {
    public void createUser(final UserModel userModel);
}

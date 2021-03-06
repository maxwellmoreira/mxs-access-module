package com.mxs.domain.user.usecase.create;

import com.mxs.model.UserModel;

import java.util.List;

public interface CreateUseCase {
    void createUser(final List<UserModel> userModelList);
}
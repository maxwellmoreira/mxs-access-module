package com.mxs.domain.user.usecase.create;

import com.mxs.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface CreateUseCase {
    public void createUser(final List<Optional<UserModel>> userModelOptionalList);
}
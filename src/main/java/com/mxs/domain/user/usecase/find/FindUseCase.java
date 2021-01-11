package com.mxs.domain.user.usecase.find;

import com.mxs.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface FindUseCase {
    public List<Optional<UserModel>> findUser(final Optional<UserModel> userModelOptional);
}

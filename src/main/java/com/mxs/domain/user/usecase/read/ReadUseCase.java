package com.mxs.domain.user.usecase.read;

import com.mxs.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface ReadUseCase {
    public List<Optional<UserModel>> findUser(final Optional<UserModel> userModelOptional);
}

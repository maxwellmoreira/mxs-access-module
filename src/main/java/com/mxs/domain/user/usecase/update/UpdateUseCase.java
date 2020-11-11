package com.mxs.domain.user.usecase.update;

import com.mxs.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface UpdateUseCase {
    public void updateUser(final List<Optional<UserModel>> userModelOptionalList);
}

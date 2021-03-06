package com.mxs.domain.user.usecase.find;

import com.mxs.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface FindUseCase {
    List<UserModel> findUser(final UserModel userModel);
}

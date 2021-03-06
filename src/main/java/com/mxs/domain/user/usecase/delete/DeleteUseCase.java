package com.mxs.domain.user.usecase.delete;

import com.mxs.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface DeleteUseCase {
    void removeUser(final List<UserModel> userModelList);
}
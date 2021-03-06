package com.mxs.domain.user.usecase.update;

import com.mxs.model.UserModel;

import java.util.List;

public interface UpdateUseCase {
    void updateUser(final List<UserModel> userModelList);
}

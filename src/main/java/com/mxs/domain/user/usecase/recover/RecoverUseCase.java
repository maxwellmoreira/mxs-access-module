package com.mxs.domain.user.usecase.recover;

import com.mxs.factory.type.RecoveryType;
import com.mxs.model.UserModel;

import java.util.Optional;

public interface RecoverUseCase {
    public void recoverAccess(final Optional<UserModel> userModelOptional, final RecoveryType recoveryType);
}
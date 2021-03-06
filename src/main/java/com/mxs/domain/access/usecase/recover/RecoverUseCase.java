package com.mxs.domain.access.usecase.recover;

import com.mxs.factory.type.RecoveryType;
import com.mxs.model.UserModel;

public interface RecoverUseCase {
    void recoverAccess(final UserModel userModel, final RecoveryType recoveryType);
}
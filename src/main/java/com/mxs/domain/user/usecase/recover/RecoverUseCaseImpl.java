package com.mxs.domain.user.usecase.recover;

import com.mxs.factory.type.RecoveryType;
import com.mxs.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public final class RecoverUseCaseImpl implements RecoverUseCase {
    @Override
    public void recoverAccess(final Optional<UserModel> userModelOptional, final RecoveryType recoveryType) {

    }
}
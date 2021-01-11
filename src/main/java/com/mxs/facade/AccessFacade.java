package com.mxs.facade;

import com.mxs.domain.access.usecase.login.LoginUseCase;
import com.mxs.domain.access.usecase.password.PasswordUseCase;
import com.mxs.domain.access.usecase.recover.RecoverUseCase;
import com.mxs.factory.type.RecoveryType;
import com.mxs.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public final class AccessFacade {

    @Autowired
    private LoginUseCase loginUseCase;

    @Autowired
    private PasswordUseCase passwordUseCase;

    @Autowired
    private RecoverUseCase recoverUseCase;

    public Optional<UserModel> registerUser(final Optional<UserModel> userModelOptional) {
        return null;
    }

    public Optional<UserModel> login(final Optional<UserModel> userModelOptional) {
        return this.loginUseCase.login(userModelOptional);
    }

    public void changePassword(final Optional<UserModel> userModelView) {
        this.passwordUseCase.changePassword(userModelView);
    }

    public void recoverAccess(final Optional<UserModel> userModelOptional, final RecoveryType recoveryType) {
        this.recoverUseCase.recoverAccess(userModelOptional, recoveryType);
    }
}

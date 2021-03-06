package com.mxs.facade;

import com.mxs.domain.access.usecase.login.LoginUseCase;
import com.mxs.domain.access.usecase.password.PasswordUseCase;
import com.mxs.domain.access.usecase.recover.RecoverUseCase;
import com.mxs.domain.access.usecase.register.RegisterUseCase;
import com.mxs.factory.type.RecoveryType;
import com.mxs.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class AccessFacade {

    @Autowired
    private RegisterUseCase registerUseCase;

    @Autowired
    private LoginUseCase loginUseCase;

    @Autowired
    private PasswordUseCase passwordUseCase;

    @Autowired
    private RecoverUseCase recoverUseCase;

    public void registerUser(final UserModel userModel) {
        this.registerUseCase.register(userModel);
    }

    public UserModel login(final UserModel userModel) {
        return this.loginUseCase.login(userModel);
    }

    public void changePassword(final UserModel userModel) {
        this.passwordUseCase.changePassword(userModel);
    }

    public void recoverAccess(final UserModel userModel, final RecoveryType recoveryType) {
        this.recoverUseCase.recoverAccess(userModel, recoveryType);
    }
}
package com.mxs.domain.access.usecase.recover;

import com.mxs.domain.user.port.out.UserRepositoryOutPort;
import com.mxs.factory.exception.ResourceExistsException;
import com.mxs.factory.type.MessageExceptionType;
import com.mxs.factory.type.RecoveryType;
import com.mxs.factory.util.EmailUtil;
import com.mxs.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class RecoverUseCaseImpl implements RecoverUseCase {

    @Autowired
    private UserRepositoryOutPort userRepositoryOutPort;

    @Autowired
    private EmailUtil emailUtil;

    @Override
    public void recoverAccess(final UserModel userModel, final RecoveryType recoveryType) {
        UserModel user = findUserByUsernameOrEmail(userModel);
        this.emailUtil.sendEmailWithoutAttachment(user.getEmail());
    }

    private UserModel findUserByUsernameOrEmail(final UserModel userModel) {
        return this.userRepositoryOutPort.findByUsernameOrEmail(userModel.getUsername(), userModel.getEmail())
                .stream()
                .findFirst()
                .orElseThrow(() -> new ResourceExistsException(MessageExceptionType.USER_NOT_FOUND));
    }
}
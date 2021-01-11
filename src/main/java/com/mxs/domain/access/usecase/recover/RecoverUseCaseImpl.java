package com.mxs.domain.access.usecase.recover;

import com.mxs.domain.user.port.out.UserRepositoryOutPort;
import com.mxs.factory.exception.ResourceExistsException;
import com.mxs.factory.type.MessageExceptionType;
import com.mxs.factory.type.RecoveryType;
import com.mxs.factory.util.EmailUtil;
import com.mxs.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public final class RecoverUseCaseImpl implements RecoverUseCase {

    @Autowired
    private UserRepositoryOutPort userRepositoryOutPort;

    @Autowired
    private EmailUtil emailUtil;

    @Override
    public void recoverAccess(final Optional<UserModel> userModelOptional, final RecoveryType recoveryType) {
        Optional<UserModel> userModel = findUserByUsernameOrEmail(userModelOptional);
        userModel.ifPresent(user -> this.emailUtil.sendEmailWithoutAttachment(user.getEmail()));
    }

    private Optional<UserModel> findUserByUsernameOrEmail(final Optional<UserModel> userModelOptional) {
        return userModelOptional.map(userModel ->
                this.userRepositoryOutPort.findByUsernameOrEmail(userModel.getUsername(), userModel.getEmail()))
                .stream()
                .filter(user -> user.isPresent())
                .findFirst()
                .orElseThrow(() -> new ResourceExistsException(MessageExceptionType.USER_NOT_FOUND));
    }
}
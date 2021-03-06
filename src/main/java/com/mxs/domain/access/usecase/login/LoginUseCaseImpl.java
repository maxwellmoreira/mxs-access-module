package com.mxs.domain.access.usecase.login;

import com.mxs.domain.user.port.out.UserRepositoryOutPort;
import com.mxs.factory.exception.ResourceExistsException;
import com.mxs.factory.type.MessageExceptionType;
import com.mxs.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class LoginUseCaseImpl implements LoginUseCase {

    @Autowired
    private UserRepositoryOutPort userRepositoryOutPort;

    @Override
    public UserModel login(final UserModel userModel) {
        return this.userRepositoryOutPort.findByUsernameAndPassword(userModel.getUsername(), userModel.getPassword())
                .stream()
                .findFirst()
                .orElseThrow(() -> new ResourceExistsException(MessageExceptionType.USER_NOT_FOUND));
    }
}

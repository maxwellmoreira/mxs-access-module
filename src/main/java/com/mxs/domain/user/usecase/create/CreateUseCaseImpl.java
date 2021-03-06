package com.mxs.domain.user.usecase.create;

import com.mxs.domain.user.port.out.UserRepositoryOutPort;
import com.mxs.factory.exception.ResourceExistsException;
import com.mxs.factory.type.MessageExceptionType;
import com.mxs.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class CreateUseCaseImpl implements CreateUseCase {

    @Autowired
    private UserRepositoryOutPort userRepositoryOutPort;

    @Override
    public void createUser(final List<UserModel> userModelList) {
        userModelList.forEach(this::create);
    }

    private void create(final UserModel userModel) {
        usernameExists(userModel);
        this.userRepositoryOutPort.createUser(userModel);
    }

    private void usernameExists(final UserModel userModel) {
        this.userRepositoryOutPort.findByUsername(userModel.getUsername())
                .stream()
                .findFirst()
                .ifPresent(user -> { throw new ResourceExistsException(MessageExceptionType.USERNAME_EXISTS); });
    }
}
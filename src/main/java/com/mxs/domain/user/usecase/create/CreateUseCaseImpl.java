package com.mxs.domain.user.usecase.create;

import com.mxs.domain.user.port.out.UserRepositoryOutPort;
import com.mxs.exception.ResourceExistsException;
import com.mxs.factory.type.CodeExceptionType;
import com.mxs.factory.type.MessageExceptionType;
import com.mxs.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public final class CreateUseCaseImpl implements CreateUseCase {

    @Autowired
    private UserRepositoryOutPort userRepositoryOutPort;

    @Override
    public void createUser(final List<Optional<UserModel>> userModelOptionalList) {
        userModelOptionalList.stream().forEach(this::create);
    }

    private void create(final Optional<UserModel> userModelOptional) {
        userModelOptional.ifPresent(user -> {
            if (usernameExists(user.getUsername())) {
                throw new ResourceExistsException(CodeExceptionType.EXISTS, MessageExceptionType.USERNAME_EXISTS);
            } else {
                this.userRepositoryOutPort.createUser(userModelOptional);
            }
        });
    }

    private Boolean usernameExists(final String username) {
        return this.userRepositoryOutPort.usernameExists(username);
    }
}
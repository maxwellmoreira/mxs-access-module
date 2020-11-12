package com.mxs.domain.user.usecase.create;

import com.mxs.domain.user.port.out.UserRepositoryOutPort;
import com.mxs.factory.exception.ResourceExistsException;
import com.mxs.factory.type.MessageExceptionType;
import com.mxs.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public final class CreateUseCaseImpl implements CreateUseCase {

    @Autowired
    private UserRepositoryOutPort userRepositoryOutPort;

    @Override
    public void createUser(final List<Optional<UserModel>> userModelOptionalList) {
        userModelOptionalList.stream().forEach(this::create);
    }

    private void create(final Optional<UserModel> userModelOptional) {
        usernameExists(userModelOptional);
        this.userRepositoryOutPort.createUser(userModelOptional);
    }

    private void usernameExists(final Optional<UserModel> userModelOptional) {
        userModelOptional.map(userModel -> this.userRepositoryOutPort.findByUsername(userModel.getUsername()))
                .stream()
                .findFirst()
                .ifPresent(userModel -> new ResourceExistsException(MessageExceptionType.USERNAME_EXISTS));
    }
}
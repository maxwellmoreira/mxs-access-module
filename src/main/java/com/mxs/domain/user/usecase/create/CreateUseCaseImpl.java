package com.mxs.domain.user.usecase.create;

import com.mxs.domain.user.port.out.UserRepositoryOutPort;
import com.mxs.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public final class CreateUseCaseImpl implements CreateUseCase {

    @Autowired
    private UserRepositoryOutPort userRepositoryOutPort;

    @Override
    public void createUser(final List<Optional<UserModel>> userModelOptionalList) {
        userModelOptionalList.stream().map(user -> usernameExists(user.get().getUsername()));
    }

    private Boolean usernameExists(final String username) {
        return this.userRepositoryOutPort.usernameExists(username);
    }
}
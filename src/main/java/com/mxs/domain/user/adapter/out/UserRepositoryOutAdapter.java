package com.mxs.domain.user.adapter.out;

import com.mxs.domain.user.port.out.UserRepositoryOutPort;
import com.mxs.model.UserModel;
import com.mxs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public final class UserRepositoryOutAdapter implements UserRepositoryOutPort {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(final Optional<UserModel> userModelOptional) {
    }

    @Override
    public List<Optional<UserModel>> findUser(final Optional<UserModel> userModelOptional) {
        return null;
    }

    @Override
    public void updateUser(final Optional<UserModel> userModelOptional) {
    }

    @Override
    public void removeUser(final Optional<UserModel> userModelOptional) {
    }

    @Override
    public Boolean usernameExists(final String username) {
        return false;
    }

    @Override
    public Boolean userExists(Optional<UserModel> userModelOptional) {
        return null;
    }
}
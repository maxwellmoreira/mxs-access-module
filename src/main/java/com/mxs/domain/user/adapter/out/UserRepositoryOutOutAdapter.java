package com.mxs.domain.user.adapter.out;

import com.mxs.domain.user.port.out.UserRepositoryOutPort;
import com.mxs.filter.UserFilter;
import com.mxs.model.UserModel;
import com.mxs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public final class UserRepositoryOutOutAdapter implements UserRepositoryOutPort {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(final UserModel userModel) {
        this.userRepository.save(userModel);
    }

    @Override
    public UserModel findUser(final UserFilter userFilter) {
        return null;
    }

    @Override
    public void updateUser(final UserModel userModel) {

    }

    @Override
    public void removeUser(final Long code) {

    }

    @Override
    public Boolean usernameExists(final String username) {
        return false;
    }
}
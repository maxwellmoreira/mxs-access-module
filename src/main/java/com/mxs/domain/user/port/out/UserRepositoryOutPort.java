package com.mxs.domain.user.port.out;

import com.mxs.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryOutPort {
    void createUser(final UserModel userModel);

    List<UserModel> findUser(final UserModel userModel);

    void updateUser(final UserModel userModel);

    void removeUser(final UserModel userModel);

    Optional<UserModel> findByEmail(final String email);

    Optional<UserModel> findByUsername(final String username);

    Optional<UserModel> findByUsernameAndPassword(final String username, final String password);

    Optional<UserModel> findByUsernameAndEmail(final String username, final String email);

    Optional<UserModel> findByUsernameOrEmail(final String username, final String email);
}
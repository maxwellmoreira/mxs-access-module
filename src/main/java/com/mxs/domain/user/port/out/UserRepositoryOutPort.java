package com.mxs.domain.user.port.out;

import com.mxs.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryOutPort {
    public void createUser(final Optional<UserModel> userModelOptional);

    public List<Optional<UserModel>> findUser(final Optional<UserModel> userModelOptional);

    public void updateUser(final Optional<UserModel> userModelOptional);

    public void removeUser(final Optional<UserModel> userModelOptional);

    public Optional<UserModel> findByUsername(final String username);

    public Optional<UserModel> findByUsernameAndEmail(final String username, final String email);

    public Optional<UserModel> findByUsernameAndPassword(final String username, final String password);

    public Optional<UserModel> findByEmail(final String email);
}

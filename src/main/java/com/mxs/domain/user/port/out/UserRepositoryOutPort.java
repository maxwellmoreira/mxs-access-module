package com.mxs.domain.user.port.out;

import com.mxs.model.UserModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepositoryOutPort {
    public void createUser(final Optional<UserModel> userModelOptional);
    public List<Optional<UserModel>> findUser(final Optional<UserModel> userModelOptional);
    public void updateUser(final Optional<UserModel> userModelOptional);
    public void removeUser(final Optional<UserModel> userModelOptional);
    public Boolean usernameExists(final String username);
    public Boolean userExists(final Optional<UserModel> userModelOptional);
}

package com.mxs.domain.user.port.out;

import com.mxs.filter.UserFilter;
import com.mxs.model.UserModel;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryOutPort {
    public void createUser(final Optional<UserModel> userModelOptional);
    public Optional<UserModel> findUser(final UserFilter userFilter);
    public void updateUser(final Optional<UserModel> userModelOptional);
    public void removeUser(final Optional<UserModel> userModelOptional);
    public Boolean usernameExists(final String username);
}

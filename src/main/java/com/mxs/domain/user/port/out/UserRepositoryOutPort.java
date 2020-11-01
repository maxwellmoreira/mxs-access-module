package com.mxs.domain.user.port.out;

import com.mxs.filter.UserFilter;
import com.mxs.model.UserModel;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryOutPort {
    public void createUser(final UserModel userModel);
    public UserModel findUser(final UserFilter userFilter);
    public void updateUser(final UserModel userModel);
    public void removeUser(final Long code);
    public Boolean userExists(final String email, final String username);
}

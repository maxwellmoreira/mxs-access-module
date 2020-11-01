package com.mxs.domain.user.facade;

import com.mxs.dto.UserDto;
import com.mxs.filter.UserFilter;
import com.mxs.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public final class UserFacade {

    public void addUser(final List<Optional<UserModel>> userModelOptionalList) {

    }

    public List<UserDto> findUser(final UserFilter userFilter) {
        return null;
    }

    public void updateUser(final Optional<UserModel> userModel) {

    }

    public void removeUser(final Long code) {

    }
}
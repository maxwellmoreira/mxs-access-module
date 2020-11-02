package com.mxs.domain.user.adapter.in;

import com.mxs.converter.UserConverter;
import com.mxs.converter.UserFilterConverter;
import com.mxs.domain.user.facade.UserFacade;
import com.mxs.domain.user.port.in.UserControllerInPort;
import com.mxs.dto.UserDto;
import com.mxs.filter.UserFilter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public final class UserControllerInInAdapter implements UserControllerInPort {

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private UserFilterConverter userFilterConverter;

    @Autowired
    private UserFacade userFacade;

    @Override
    public void addUser(final List<UserDto> userDtoList) {
        this.userFacade.createUser(userConverter.convertToModelList(userDtoList));
    }

    @Override
    public List<UserDto> findUser(final UserFilter userFilter) {
        return this.userConverter.convertToDtoList(
                this.userFacade.readUser(
                        this.userFilterConverter.convertToModel(userFilter)));
    }

    @Override
    public void updateUser(final List<UserDto> userDtoList) {
        this.userFacade.updateUser(this.userConverter.convertToModelList(userDtoList));
    }

    @Override
    public void removeUser(final List<UserDto> userDtoList) {
        this.userFacade.deleteUser(this.userConverter.convertToModelList(userDtoList));
    }
}
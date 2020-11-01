package com.mxs.domain.user.adapter.in;

import com.mxs.converter.UserConverter;
import com.mxs.dto.UserDto;
import com.mxs.filter.UserFilter;
import com.mxs.domain.user.port.in.UserControllerInPort;
import com.mxs.domain.user.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;

public final class UserControllerInInAdapter implements UserControllerInPort {

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private UserFacade userFacade;

    @Override
    public void addUser(final UserDto userDto) {
        this.userFacade.addUser(this.userConverter.convertToModel(userDto));
    }

    @Override
    public UserDto findUser(final UserFilter userFilter) {
        return this.userConverter.convertToDto(this.userFacade.findUser(userFilter));
    }

    @Override
    public void updateUser(final UserDto userDto) {
        this.userFacade.updateUser(this.userConverter.convertToModel(userDto));
    }

    @Override
    public void removeUser(final Long code) {
        this.userFacade.removeUser(code);
    }
}
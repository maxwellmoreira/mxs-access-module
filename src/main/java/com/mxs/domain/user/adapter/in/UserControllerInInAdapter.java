package com.mxs.domain.user.adapter.in;

import com.mxs.converter.UserConverter;
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
    private UserFacade userFacade;

    @Override
    public void addUser(final List<UserDto> userDtoList) {
        this.userFacade.addUser(userConverter.convertToModelList(userDtoList));
    }

    @Override
    public List<UserDto> findUser(final UserFilter userFilter) {
        return this.userFacade.findUser(userFilter);
    }

    @Override
    public void updateUser(final UserDto userDto) {
    }

    @Override
    public void removeUser(final Long code) {
    }
}
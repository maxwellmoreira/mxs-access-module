package com.mxs.domain.user.adapter.in;

import com.mxs.domain.user.converter.UserConverter;
import com.mxs.domain.user.port.in.UserControllerInPort;
import com.mxs.dto.UserDto;
import com.mxs.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public final class UserControllerInAdapter implements UserControllerInPort {

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private UserConverter userConverter;

    @Override
    public void addUser(final List<UserDto> userDtoList) {
        this.userFacade.addUser(this.userConverter.convertToModelList(userDtoList));
    }

    @Override
    public ResponseEntity<List<UserDto>> findUser(final UserDto userDto) {

        final List<UserDto> userDtoList =
                this.userConverter.convertToDtoList(
                        this.userFacade.findUser(
                                this.userConverter.convertToModel(userDto)));

        return new ResponseEntity<>(userDtoList, HttpStatus.OK);
    }

    @Override
    public void updateUser(final List<UserDto> userDtoList) {
        this.userFacade.updateUser(this.userConverter.convertToModelList(userDtoList));
    }

    @Override
    public void removeUser(final List<UserDto> userDtoList) {
        this.userFacade.removeUser(this.userConverter.convertToModelList(userDtoList));
    }
}
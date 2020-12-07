package com.mxs.domain.user.adapter.in;

import com.mxs.domain.user.converter.*;
import com.mxs.domain.user.dto.*;
import com.mxs.facade.UserFacade;
import com.mxs.domain.user.port.in.UserCrudControllerInPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public final class UserCrudCrudControllerInAdapter implements UserCrudControllerInPort {

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private SearchConverter searchConverter;

    @Autowired
    private ChangePasswordConverter changePasswordConverter;

    @Autowired
    private UserFacade userFacade;

    @Override
    public ResponseEntity<List<UserDto>> findUser(final SearchDto userFilter) {

        final List<UserDto> userDtoList =
                this.userConverter.convertToDtoList(
                        this.userFacade.findUser(
                                this.searchConverter.convertToModel(userFilter)));

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

    @Override
    public void changePassword(final ChangePasswordDto changePasswordFilter) {
        this.userFacade.changePassword(this.changePasswordConverter.convertToModel(changePasswordFilter));
    }
}
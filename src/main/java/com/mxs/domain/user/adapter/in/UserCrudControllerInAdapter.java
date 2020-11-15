package com.mxs.domain.user.adapter.in;

import com.mxs.domain.user.converter.ChangePasswordConverter;
import com.mxs.domain.user.converter.LoginConverter;
import com.mxs.domain.user.converter.UserConverter;
import com.mxs.domain.user.converter.SearchConverter;
import com.mxs.domain.user.dto.ChangePasswordDto;
import com.mxs.domain.user.dto.LoginDto;
import com.mxs.facade.UserFacade;
import com.mxs.domain.user.dto.SearchDto;
import com.mxs.domain.user.port.in.UserControllerInPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public final class UserCrudControllerInAdapter implements UserControllerInPort {

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private SearchConverter userFilterConverter;

    @Autowired
    private LoginConverter loginFilterConverter;

    @Autowired
    private ChangePasswordConverter changePasswordConverter;

    @Autowired
    private UserFacade userFacade;

    @Override
    public void addUser(final List<com.mxs.domain.user.dto.UserDto> userDtoList) {
        this.userFacade.createUser(userConverter.convertToModelList(userDtoList));
    }

    @Override
    public ResponseEntity<List<com.mxs.domain.user.dto.UserDto>> findUser(final SearchDto userFilter) {

        final List<com.mxs.domain.user.dto.UserDto> userDtoList =
                this.userConverter.convertToDtoList(
                        this.userFacade.findUser(
                                this.userFilterConverter.convertToModel(userFilter)));

        return new ResponseEntity<List<com.mxs.domain.user.dto.UserDto>>(userDtoList, HttpStatus.OK);
    }

    @Override
    public void updateUser(final List<com.mxs.domain.user.dto.UserDto> userDtoList) {
        this.userFacade.updateUser(this.userConverter.convertToModelList(userDtoList));
    }

    @Override
    public void removeUser(final List<com.mxs.domain.user.dto.UserDto> userDtoList) {
        this.userFacade.removeUser(this.userConverter.convertToModelList(userDtoList));
    }

    @Override
    public ResponseEntity<com.mxs.domain.user.dto.UserDto> login(final LoginDto loginFilter) {

        final com.mxs.domain.user.dto.UserDto userDto =
                this.userConverter.convertToDto(
                        this.userFacade.login(
                                this.loginFilterConverter.convertToModel(loginFilter)));

        return new ResponseEntity<com.mxs.domain.user.dto.UserDto>(userDto, HttpStatus.OK);
    }

    @Override
    public void changePassword(final ChangePasswordDto changePasswordFilter) {
        this.userFacade.changePassword(this.changePasswordConverter.convertToModel(changePasswordFilter));
    }
}
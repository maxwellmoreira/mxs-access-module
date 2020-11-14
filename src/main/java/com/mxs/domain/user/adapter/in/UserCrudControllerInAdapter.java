package com.mxs.domain.user.adapter.in;

import com.mxs.domain.user.converter.ChangePasswordConverter;
import com.mxs.domain.user.converter.LoginFilterConverter;
import com.mxs.domain.user.converter.UserConverter;
import com.mxs.domain.user.converter.UserFilterConverter;
import com.mxs.domain.user.dto.UserDto;
import com.mxs.domain.user.filter.ChangePasswordFilter;
import com.mxs.domain.user.filter.LoginFilter;
import com.mxs.facade.UserFacade;
import com.mxs.domain.user.filter.UserFilter;
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
    private UserFilterConverter userFilterConverter;

    @Autowired
    private LoginFilterConverter loginFilterConverter;

    @Autowired
    private ChangePasswordConverter changePasswordConverter;

    @Autowired
    private UserFacade userFacade;

    @Override
    public void addUser(final List<UserDto> userDtoList) {
        this.userFacade.createUser(userConverter.convertToModelList(userDtoList));
    }

    @Override
    public ResponseEntity<List<UserDto>> findUser(final UserFilter userFilter) {

        final List<UserDto> userDtoList =
                this.userConverter.convertToDtoList(
                        this.userFacade.findUser(
                                this.userFilterConverter.convertToModel(userFilter)));

        return new ResponseEntity<List<UserDto>>(userDtoList, HttpStatus.OK);
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
    public ResponseEntity<UserDto> login(final LoginFilter loginFilter) {

        final UserDto userDto =
                this.userConverter.convertToDto(
                        this.userFacade.login(
                                this.loginFilterConverter.convertToModel(loginFilter)));

        return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
    }

    @Override
    public void changePassword(final ChangePasswordFilter changePasswordFilter) {
        this.userFacade.changePassword(this.changePasswordConverter.convertToModel(changePasswordFilter));
    }
}
package com.mxs.domain.user.adapter.in;

import com.mxs.domain.user.converter.LoginConverter;
import com.mxs.domain.user.converter.RecoverAccessConverter;
import com.mxs.domain.user.converter.UserConverter;
import com.mxs.domain.user.dto.LoginDto;
import com.mxs.domain.user.dto.RecoverAccessDto;
import com.mxs.domain.user.dto.UserDto;
import com.mxs.domain.user.port.in.UserAccessControllerInPort;
import com.mxs.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public final class UserAccessControllerInAdapter implements UserAccessControllerInPort {

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private LoginConverter loginFilterConverter;

    @Autowired
    private RecoverAccessConverter recoverAccessConverter;

    @Autowired
    private UserFacade userFacade;

    @Override
    public void addUser(final List<UserDto> userDtoList) {
        this.userFacade.createUser(this.userConverter.convertToModelList(userDtoList));
    }

    @Override
    public ResponseEntity<UserDto> login(final LoginDto loginFilter) {

        final UserDto userDto =
                this.userConverter.convertToDto(
                        this.userFacade.login(
                                this.loginFilterConverter.convertToModel(loginFilter)));

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @Override
    public void recoverAccess(final RecoverAccessDto recoverAccessDto) {
        this.userFacade.recoverAccess(
                this.recoverAccessConverter.convertToModel(recoverAccessDto), recoverAccessDto.getRecoveryType());
    }
}
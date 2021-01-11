package com.mxs.domain.access.adapter.in;

import com.mxs.domain.access.converter.ChangePasswordConverter;
import com.mxs.domain.access.converter.LoginConverter;
import com.mxs.domain.access.converter.RecoverAccessConverter;
import com.mxs.domain.access.port.in.AccessControllerInPort;
import com.mxs.dto.*;
import com.mxs.facade.AccessFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public final class AccessControllerInAdapter implements AccessControllerInPort {

    @Autowired
    private AccessFacade accessFacade;

    @Autowired
    private LoginConverter loginConverter;

    @Autowired
    private ChangePasswordConverter changePasswordConverter;

    @Autowired
    private RecoverAccessConverter recoverAccessConverter;

    @Override
    public void registerUser(final List<UserDto> userDtoList) {
        this.accessFacade.createUser(this.userConverter.convertToModelList(userDtoList));
    }

    @Override
    public ResponseEntity<LoginResponseDto> loginUser(final LoginDto loginFilter) {
        LoginResponseDto loginResponseDto = null;
        return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
    }

    @Override
    public void changePassword(final ChangePasswordDto changePasswordDto) {
        this.accessFacade.changePassword(this.changePasswordConverter.convertToModel(changePasswordDto));
    }

    @Override
    public void recoverAccess(final RecoverAccessDto recoverAccessDto) {
        this.accessFacade.recoverAccess(
                this.recoverAccessConverter.convertToModel(recoverAccessDto), recoverAccessDto.getRecoveryType());
    }
}
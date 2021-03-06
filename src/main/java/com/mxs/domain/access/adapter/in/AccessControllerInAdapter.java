package com.mxs.domain.access.adapter.in;

import com.mxs.domain.access.converter.ChangePasswordConverter;
import com.mxs.domain.access.converter.LoginConverter;
import com.mxs.domain.access.converter.RecoverAccessConverter;
import com.mxs.domain.access.converter.RegisterConverter;
import com.mxs.domain.access.port.in.AccessControllerInPort;
import com.mxs.dto.*;
import com.mxs.facade.AccessFacade;
import com.mxs.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class AccessControllerInAdapter implements AccessControllerInPort {

    @Autowired
    private AccessFacade accessFacade;

    @Autowired
    private RegisterConverter registerConverter;

    @Autowired
    private LoginConverter loginConverter;

    @Autowired
    private ChangePasswordConverter changePasswordConverter;

    @Autowired
    private RecoverAccessConverter recoverAccessConverter;

    @Override
    public void registerUser(final RegisterDto registerDto) {
        UserModel userModel = this.registerConverter.convertToModel(registerDto);
        this.accessFacade.registerUser(userModel);
    }

    @Override
    public ResponseEntity<LoginResponseDto> loginUser(final LoginDto loginFilter) {
        LoginResponseDto loginResponseDto = null;
        return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
    }

    @Override
    public void changePassword(final ChangePasswordDto changePasswordDto) {
        UserModel userModel = this.changePasswordConverter.convertToModel(changePasswordDto);
        this.accessFacade.changePassword(userModel);
    }

    @Override
    public void recoverAccess(final RecoverAccessDto recoverAccessDto) {
        UserModel userModel = this.recoverAccessConverter.convertToModel(recoverAccessDto);
        this.accessFacade.recoverAccess(userModel, recoverAccessDto.getRecoveryType());
    }
}
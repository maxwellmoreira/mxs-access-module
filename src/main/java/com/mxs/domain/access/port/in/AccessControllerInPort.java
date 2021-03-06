package com.mxs.domain.access.port.in;

import com.mxs.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.mxs.factory.constant.ModelControllerConstant.ACCESSES;
import static com.mxs.factory.constant.UriControllerConstant.REGISTER;
import static com.mxs.factory.constant.UriControllerConstant.LOGIN;
import static com.mxs.factory.constant.UriControllerConstant.CHANGE_PASSWORD;
import static com.mxs.factory.constant.UriControllerConstant.RECOVER_ACCESS;

@RequestMapping(ACCESSES)
public interface AccessControllerInPort {
    @PostMapping(REGISTER)
    void registerUser(final @RequestBody RegisterDto registerDto);

    @PostMapping(LOGIN)
    ResponseEntity<LoginResponseDto> loginUser(final @RequestBody LoginDto loginDto);

    @PutMapping(CHANGE_PASSWORD)
    void changePassword(final @RequestBody ChangePasswordDto changePasswordDto);

    @DeleteMapping(RECOVER_ACCESS)
    void recoverAccess(final @RequestBody RecoverAccessDto recoverAccessDto);
}
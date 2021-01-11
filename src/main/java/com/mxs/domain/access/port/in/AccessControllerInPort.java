package com.mxs.domain.access.port.in;

import com.mxs.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mxs.factory.constant.ModelControllerConstant.ACCESS;
import static com.mxs.factory.constant.UriControllerConstant.*;

@RequestMapping(ACCESS)
public interface AccessControllerInPort {
    @PostMapping(REGISTER)
    public void registerUser(final @RequestBody List<UserDto> userDtoList);

    @PostMapping(LOGIN)
    public ResponseEntity<LoginResponseDto> loginUser(final @RequestBody LoginDto loginDto);

    @PutMapping(CHANGE_PASSWORD)
    public void changePassword(final @RequestBody ChangePasswordDto changePasswordDto);

    @DeleteMapping(RECOVER)
    public void recoverAccess(final @RequestBody RecoverAccessDto recoverAccessDto);
}
package com.mxs.domain.user.port.in;

import com.mxs.domain.user.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mxs.factory.constant.ModelControllerConstant.USERS;
import static com.mxs.factory.constant.UriControllerConstant.CHANGE_PASSWORD;
import static com.mxs.factory.constant.UriControllerConstant.LOGIN;
import static com.mxs.factory.constant.UriControllerConstant.RECOVER_ACCESS;

@RequestMapping(USERS)
public interface UserControllerInPort {

    @PostMapping
    public void addUser(final @RequestBody List<UserDto> userDtoList);

    @GetMapping
    public ResponseEntity<List<UserDto>> findUser(final @RequestBody SearchDto userFilter);

    @PutMapping
    public void updateUser(final @RequestBody List<UserDto> userDtoList);

    @DeleteMapping
    public void removeUser(final @RequestBody List<UserDto> userDtoList);

    @GetMapping(LOGIN)
    public ResponseEntity<UserDto> login(final @RequestBody LoginDto loginFilter);

    @PutMapping(CHANGE_PASSWORD)
    public void changePassword(final @RequestBody ChangePasswordDto changePasswordFilter);

    @PostMapping(RECOVER_ACCESS)
    public void recoverAccess(final @RequestBody RecoverAccessDto recoverAccessDto);
}
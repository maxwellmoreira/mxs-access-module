package com.mxs.domain.user.port.in;

import com.mxs.domain.user.dto.ChangePasswordDto;
import com.mxs.domain.user.dto.LoginDto;
import com.mxs.domain.user.dto.SearchDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mxs.factory.constant.ModelControllerConstant.USERS;
import static com.mxs.factory.constant.UriControllerConstant.CHANGE_PASSWORD;
import static com.mxs.factory.constant.UriControllerConstant.LOGIN;

@RequestMapping(USERS)
public interface UserControllerInPort {

    @PostMapping
    public void addUser(final @RequestBody List<com.mxs.domain.user.dto.UserDto> userDtoList);

    @GetMapping
    public ResponseEntity<List<com.mxs.domain.user.dto.UserDto>> findUser(final @RequestBody SearchDto userFilter);

    @PutMapping
    public void updateUser(final @RequestBody List<com.mxs.domain.user.dto.UserDto> userDtoList);

    @DeleteMapping
    public void removeUser(final @RequestBody List<com.mxs.domain.user.dto.UserDto> userDtoList);

    @GetMapping(LOGIN)
    public ResponseEntity<com.mxs.domain.user.dto.UserDto> login(final @RequestBody LoginDto loginFilter);

    @PutMapping(CHANGE_PASSWORD)
    public void changePassword(final @RequestBody ChangePasswordDto changePasswordFilter);
}
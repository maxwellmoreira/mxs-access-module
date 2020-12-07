package com.mxs.domain.user.port.in;

import com.mxs.domain.user.dto.ChangePasswordDto;
import com.mxs.domain.user.dto.SearchDto;
import com.mxs.domain.user.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mxs.factory.constant.ModelControllerConstant.USERS;
import static com.mxs.factory.constant.UriControllerConstant.CHANGE_PASSWORD;

@RequestMapping(USERS)
public interface UserCrudControllerInPort {

    @GetMapping
    public ResponseEntity<List<UserDto>> findUser(final @RequestBody SearchDto userFilter);

    @PutMapping
    public void updateUser(final @RequestBody List<UserDto> userDtoList);

    @DeleteMapping
    public void removeUser(final @RequestBody List<UserDto> userDtoList);

    @PutMapping(CHANGE_PASSWORD)
    public void changePassword(final @RequestBody ChangePasswordDto changePasswordFilter);
}
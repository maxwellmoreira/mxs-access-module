package com.mxs.domain.user.port.in;

import com.mxs.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.mxs.factory.constant.ModelControllerConstant.USERS;

import java.util.List;

@RequestMapping(USERS)
public interface UserControllerInPort {
    @PostMapping
    void addUser(final @RequestBody List<UserDto> userDtoList);

    @PostMapping
    ResponseEntity<List<UserDto>> findUser(final @RequestBody UserDto userDto);

    @PutMapping
    void updateUser(final @RequestBody List<UserDto> userDtoList);

    @DeleteMapping
    void removeUser(final @RequestBody List<UserDto> userDtoList);
}
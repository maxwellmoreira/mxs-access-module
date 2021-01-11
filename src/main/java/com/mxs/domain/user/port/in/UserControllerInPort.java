package com.mxs.domain.user.port.in;

import com.mxs.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mxs.factory.constant.ModelControllerConstant.USER;

@RequestMapping(USER)
public interface UserControllerInPort {
    @PostMapping
    public void addUser(final @RequestBody List<UserDto> userDtoList);

    @PostMapping
    public ResponseEntity<List<UserDto>> findUser(final @RequestBody UserDto userDto);

    @PutMapping
    public void updateUser(final @RequestBody List<UserDto> userDtoList);

    @DeleteMapping
    public void removeUser(final @RequestBody List<UserDto> userDtoList);
}
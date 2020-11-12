package com.mxs.domain.user.port.in;

import com.mxs.domain.user.dto.UserDto;
import com.mxs.domain.user.filter.UserFilter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mxs.factory.constant.ModelControllerConstant.USERS;

@RequestMapping(USERS)
public interface UserControllerInPort {

    @PostMapping
    public void addUser(final @RequestBody List<UserDto> userDtoList);

    @GetMapping
    public ResponseEntity<List<UserDto>> findUser(final @RequestBody UserFilter userFilter);

    @PutMapping
    public void updateUser(final @RequestBody List<UserDto> userDtoList);

    @DeleteMapping
    public void removeUser(final @RequestBody List<UserDto> userDtoList);
}
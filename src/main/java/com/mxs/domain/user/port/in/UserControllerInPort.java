package com.mxs.domain.user.port.in;

import com.mxs.domain.user.dto.UserDto;
import com.mxs.domain.user.filter.UserFilter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mxs.constant.ModelControllerConstant.USERS;
import static com.mxs.constant.UriControllerConstant.*;

@RestController
@RequestMapping(USERS)
public interface UserControllerInPort {

    @PostMapping(ADD)
    public void addUser(final @RequestBody List<UserDto> userDtoList);

    @GetMapping(FIND)
    public ResponseEntity<List<UserDto>> findUser(final @RequestBody UserFilter userFilter);

    @PutMapping(UPDATE)
    public void updateUser(final @RequestBody List<UserDto> userDtoList);

    @DeleteMapping(REMOVE)
    public void removeUser(final @RequestBody List<UserDto> userDtoList);
}
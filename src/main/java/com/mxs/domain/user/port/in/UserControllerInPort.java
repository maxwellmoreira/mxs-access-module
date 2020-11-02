package com.mxs.domain.user.port.in;

import com.mxs.dto.UserDto;
import com.mxs.filter.UserFilter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mxs.constant.ModelControllerConstant.USER;
import static com.mxs.constant.UriControllerConstant.*;

@RestController
@RequestMapping(USER)
public interface UserControllerInPort {
    @PostMapping(ADD)
    public void addUser(final @RequestBody List<UserDto> userDtoList);

    @GetMapping(FIND)
    public List<UserDto> findUser(final @RequestBody UserFilter userFilter);

    @PutMapping(UPDATE)
    public void updateUser(final @RequestBody List<UserDto> userDtoList);

    @DeleteMapping(REMOVE)
    public void removeUser(final @RequestBody List<UserDto> userDtoList);
}
package com.mxs.domain.user.port.in;

import com.mxs.dto.UserDto;
import com.mxs.filter.UserFilter;
import org.springframework.web.bind.annotation.*;

import static com.mxs.constant.ModelControllerConstant.USER;
import static com.mxs.constant.UriControllerConstant.*;

@RestController
@RequestMapping(USER)
public interface UserControllerInPort {
    @PostMapping(ADD)
    public void addUser(final @RequestBody UserDto userDto);

    @GetMapping(FIND)
    public UserDto findUser(final @RequestBody UserFilter userFilter);

    @PutMapping(UPDATE)
    public void updateUser(final @RequestBody UserDto userDto);

    @DeleteMapping(REMOVE)
    public void removeUser(final @PathVariable Long code);
}
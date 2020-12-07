package com.mxs.domain.user.port.in;

import com.mxs.domain.user.dto.LoginDto;
import com.mxs.domain.user.dto.RecoverAccessDto;
import com.mxs.domain.user.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.mxs.factory.constant.ModelControllerConstant.ACCESSES;
import static com.mxs.factory.constant.UriControllerConstant.LOGIN;
import static com.mxs.factory.constant.UriControllerConstant.RECOVER_ACCESS;

@RequestMapping(ACCESSES)
public interface UserAccessControllerInPort {
    @PostMapping
    public void addUser(final @RequestBody List<UserDto> userDtoList);

    @GetMapping(LOGIN)
    public ResponseEntity<UserDto> login(final @RequestBody LoginDto loginFilter);

    @PostMapping(RECOVER_ACCESS)
    public void recoverAccess(final @RequestBody RecoverAccessDto recoverAccessDto);
}
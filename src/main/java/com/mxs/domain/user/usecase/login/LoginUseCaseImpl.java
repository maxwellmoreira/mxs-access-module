package com.mxs.domain.user.usecase.login;

import com.mxs.domain.user.port.out.UserRepositoryOutPort;
import com.mxs.factory.exception.ResourceExistsException;
import com.mxs.factory.type.MessageExceptionType;
import com.mxs.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginUseCaseImpl implements LoginUseCase {

    @Autowired
    private UserRepositoryOutPort userRepositoryOutPort;

    @Override
    public Optional<UserModel> login(Optional<UserModel> userModelOptional) {
        return userModelOptional.map(userModel ->
                this.userRepositoryOutPort.findByUsernameAndPassword(userModel.getUsername(), userModel.getPassword()))
                .stream()
                .filter(user -> user.isPresent())
                .findFirst()
                .orElseThrow(() -> new ResourceExistsException(MessageExceptionType.USER_NOT_FOUND));
    }
}

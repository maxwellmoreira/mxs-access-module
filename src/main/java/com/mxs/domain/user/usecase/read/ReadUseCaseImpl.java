package com.mxs.domain.user.usecase.read;

import com.mxs.domain.user.port.out.UserRepositoryOutPort;
import com.mxs.exception.ResourceExistsException;
import com.mxs.factory.type.CodeExceptionType;
import com.mxs.factory.type.MessageExceptionType;
import com.mxs.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public final class ReadUseCaseImpl implements ReadUseCase {

    @Autowired
    private UserRepositoryOutPort userRepositoryOutPort;

    @Override
    public List<Optional<UserModel>> findUser(final Optional<UserModel> userModelOptional) {
        if (userModelOptional.isEmpty()) {
            throw new ResourceExistsException(MessageExceptionType.USER_IS_NULL);
        }
        return find(userModelOptional);
    }

    private List<Optional<UserModel>> find(final Optional<UserModel> userModelOptional) {
        return this.userRepositoryOutPort.findUser(userModelOptional);
    }
}
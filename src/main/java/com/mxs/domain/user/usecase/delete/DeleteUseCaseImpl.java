package com.mxs.domain.user.usecase.delete;

import com.mxs.domain.user.port.out.UserRepositoryOutPort;
import com.mxs.exception.ResourceExistsException;
import com.mxs.factory.type.CodeExceptionType;
import com.mxs.factory.type.MessageExceptionType;
import com.mxs.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public final class DeleteUseCaseImpl implements DeleteUseCase {

    @Autowired
    private UserRepositoryOutPort userRepositoryOutPort;

    @Override
    public void deleteUser(List<Optional<UserModel>> userModelOptionalList) {
        userModelOptionalList.stream().forEach(this::delete);
    }

    private void delete(final Optional<UserModel> userModelOptional) {
        userModelOptional.ifPresent(user -> {
            if (userExists(user.getUsername())) {
                throw new ResourceExistsException(CodeExceptionType.EXISTS, MessageExceptionType.USER_EXISTS);
            } else {
                this.userRepositoryOutPort.removeUser(userModelOptional);
            }
        });
    }

    private Boolean userExists(final String username) {
        return false;
    }
}

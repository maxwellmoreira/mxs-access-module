package com.mxs.domain.user.usecase.delete;

import com.mxs.domain.user.port.out.UserRepositoryOutPort;
import com.mxs.exception.ResourceExistsException;
import com.mxs.factory.type.MessageExceptionType;
import com.mxs.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public final class DeleteUseCaseImpl implements DeleteUseCase {

    @Autowired
    private UserRepositoryOutPort userRepositoryOutPort;

    @Override
    public void removeUser(final List<Optional<UserModel>> userModelOptionalList) {
        userModelOptionalList.stream().forEach(this::remove);
    }

    private void remove(final Optional<UserModel> userModelOptional) {
        userModelOptional.ifPresent(user -> {
            if (userExists(user)) {
                this.userRepositoryOutPort.removeUser(userModelOptional);
            } else {
                throw new ResourceExistsException(MessageExceptionType.USER_NOT_FOUND);
            }
        });
    }

    private Boolean userExists(final UserModel userModel) {
        return !this.userRepositoryOutPort.findByUsernameAndEmail(
                userModel.getUsername(),
                userModel.getEmail()).isEmpty();
    }
}

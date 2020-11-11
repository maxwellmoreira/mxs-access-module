package com.mxs.domain.user.usecase.update;

import com.mxs.domain.user.port.out.UserRepositoryOutPort;
import com.mxs.exception.ResourceExistsException;
import com.mxs.factory.type.MessageExceptionType;
import com.mxs.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public final class UpdateUseCaseImpl implements UpdateUseCase {

    @Autowired
    private UserRepositoryOutPort userRepositoryOutPort;

    @Override
    public void updateUser(final List<Optional<UserModel>> userModelOptionalList) {
        userModelOptionalList.stream().forEach(this::update);
    }

    private void update(final Optional<UserModel> userModelOptional) {
        userModelOptional.ifPresent(user -> {
            if (userExists(user)) {
                this.userRepositoryOutPort.updateUser(userModelOptional);
            } else {
                throw new ResourceExistsException(MessageExceptionType.USER_NOT_FOUND);
            }
        });
    }

    private Boolean userExists(final UserModel userModel) {
        return !this.userRepositoryOutPort.findByUsernameAndEmail(
                userModel.getUsername(), userModel.getEmail()).isEmpty();
    }
}

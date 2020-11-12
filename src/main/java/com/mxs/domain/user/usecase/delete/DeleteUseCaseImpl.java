package com.mxs.domain.user.usecase.delete;

import com.mxs.domain.user.port.out.UserRepositoryOutPort;
import com.mxs.factory.exception.ResourceExistsException;
import com.mxs.factory.type.MessageExceptionType;
import com.mxs.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public final class DeleteUseCaseImpl implements DeleteUseCase {

    @Autowired
    private UserRepositoryOutPort userRepositoryOutPort;

    @Override
    public void removeUser(final List<Optional<UserModel>> userModelOptionalList) {
        userModelOptionalList.stream().forEach(this::remove);
    }

    private void remove(final Optional<UserModel> userModelOptional) {
        Optional<UserModel> userFounded = findUserByUsernameAndEmail(userModelOptional);
        this.userRepositoryOutPort.removeUser(userFounded);
    }

    private Optional<UserModel> findUserByUsernameAndEmail(final Optional<UserModel> userModelOptional) {
        return userModelOptional.map(userModel ->
                this.userRepositoryOutPort.findByUsernameAndEmail(userModel.getUsername(), userModel.getEmail()))
                .stream()
                .filter(user -> user.isPresent())
                .findFirst()
                .orElseThrow(() -> new ResourceExistsException(MessageExceptionType.USER_NOT_FOUND));
    }
}

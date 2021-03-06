package com.mxs.domain.user.usecase.delete;

import com.mxs.domain.user.port.out.UserRepositoryOutPort;
import com.mxs.factory.exception.ResourceExistsException;
import com.mxs.factory.type.MessageExceptionType;
import com.mxs.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class DeleteUseCaseImpl implements DeleteUseCase {

    @Autowired
    private UserRepositoryOutPort userRepositoryOutPort;

    @Override
    public void removeUser(final List<UserModel> userModelList) {
        userModelList.forEach(this::remove);
    }

    private void remove(final UserModel userModel) {
        UserModel userFounded = findUserByUsernameAndEmail(userModel);
        this.userRepositoryOutPort.removeUser(userFounded);
    }

    private UserModel findUserByUsernameAndEmail(final UserModel userModel) {
        return this.userRepositoryOutPort.findByUsernameAndEmail(userModel.getUsername(), userModel.getEmail())
                .stream()
                .findFirst()
                .orElseThrow(() -> new ResourceExistsException(MessageExceptionType.USER_NOT_FOUND));
    }
}
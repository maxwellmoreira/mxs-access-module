package com.mxs.domain.user.usecase.create;

import com.mxs.domain.user.port.out.UserRepositoryOutPort;
import com.mxs.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUseCaseImpl implements CreateUseCase {

    @Autowired
    private UserRepositoryOutPort userRepositoryOutPort;

    @Override
    public void createUser(final UserModel userModel) {
        if (userExists(userModel)) {
        }
    }

    private Boolean userExists(final UserModel userModel) {
        return this.userRepositoryOutPort.userExists(userModel.getUsername(), userModel.getEmail());
    }
}

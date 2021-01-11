package com.mxs.domain.user.usecase.find;

import com.mxs.domain.user.port.out.UserRepositoryOutPort;
import com.mxs.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public final class FindUseCaseImpl implements FindUseCase {

    @Autowired
    private UserRepositoryOutPort userRepositoryOutPort;

    @Override
    public List<Optional<UserModel>> findUser(final Optional<UserModel> userModelOptional) {
        return this.userRepositoryOutPort.findUser(userModelOptional);
    }
}
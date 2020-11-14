package com.mxs.facade;

import com.mxs.domain.user.usecase.create.CreateUseCase;
import com.mxs.domain.user.usecase.delete.DeleteUseCase;
import com.mxs.domain.user.usecase.login.LoginUseCase;
import com.mxs.domain.user.usecase.read.ReadUseCase;
import com.mxs.domain.user.usecase.update.UpdateUseCase;
import com.mxs.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public final class UserFacade {

    @Autowired
    private CreateUseCase createUseCase;

    @Autowired
    private ReadUseCase readUseCase;

    @Autowired
    private UpdateUseCase updateUseCase;

    @Autowired
    private DeleteUseCase deleteUseCase;

    @Autowired
    private LoginUseCase loginUseCase;

    public void createUser(final List<Optional<UserModel>> userModelOptionalList) {
        this.createUseCase.createUser(userModelOptionalList);
    }

    public List<Optional<UserModel>> findUser(final Optional<UserModel> userModelOptional) {
        return this.readUseCase.findUser(userModelOptional);
    }

    public void updateUser(final List<Optional<UserModel>> userModelOptionalList) {
        this.updateUseCase.updateUser(userModelOptionalList);
    }

    public void removeUser(final List<Optional<UserModel>> userModelOptionalList) {
        this.deleteUseCase.removeUser(userModelOptionalList);
    }

    public Optional<UserModel> login(final Optional<UserModel> userModelOptional) {
        return this.loginUseCase.login(userModelOptional);
    }
}
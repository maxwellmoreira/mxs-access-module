package com.mxs.domain.user.facade;

import com.mxs.domain.user.usecase.create.CreateUseCase;
import com.mxs.domain.user.usecase.delete.DeleteUseCase;
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

    public void createUser(final List<Optional<UserModel>> userModelOptionalList) {
        this.createUseCase.createUser(userModelOptionalList);
    }

    public List<Optional<UserModel>> readUser(final Optional<UserModel> userModelOptional) {
        return this.readUseCase.readUser(userModelOptional);
    }

    public void updateUser(final List<Optional<UserModel>> userModelOptionalList) {
        this.updateUseCase.updateUser(userModelOptionalList);
    }

    public void deleteUser(final List<Optional<UserModel>> userModelOptionalList) {
        this.deleteUseCase.deleteUser(userModelOptionalList);
    }
}
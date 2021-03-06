package com.mxs.facade;

import com.mxs.domain.user.usecase.create.CreateUseCase;
import com.mxs.domain.user.usecase.delete.DeleteUseCase;
import com.mxs.domain.user.usecase.find.FindUseCase;
import com.mxs.domain.user.usecase.update.UpdateUseCase;
import com.mxs.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class UserFacade {

    @Autowired
    private CreateUseCase createUseCase;

    @Autowired
    private FindUseCase findUseCase;

    @Autowired
    private UpdateUseCase updateUseCase;

    @Autowired
    private DeleteUseCase deleteUseCase;

    public void addUser(final List<UserModel> userModelList) {
        this.createUseCase.createUser(userModelList);
    }

    public List<UserModel> findUser(final UserModel userModel) {
        return this.findUseCase.findUser(userModel);
    }

    public void updateUser(final List<UserModel> userModelList) {
        this.updateUseCase.updateUser(userModelList);
    }

    public void removeUser(final List<UserModel> userModelList) {
        this.deleteUseCase.removeUser(userModelList);
    }
}
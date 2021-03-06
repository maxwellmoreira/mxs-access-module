package com.mxs.domain.access.usecase.password;

import com.mxs.domain.user.port.out.UserRepositoryOutPort;
import com.mxs.factory.exception.ResourceExistsException;
import com.mxs.factory.type.MessageExceptionType;
import com.mxs.factory.type.StatusType;
import com.mxs.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public final class PasswordUseCaseImpl implements PasswordUseCase {

    @Autowired
    private UserRepositoryOutPort userRepositoryOutPort;

    @Override
    public void changePassword(final Optional<UserModel> userModelView) {
        Optional<UserModel> userModelDataBase = findUserByUsernameAndEmail(userModelView);
        Optional<UserModel> userModelOptional = prepareUser(userModelView, userModelDataBase);
        this.userRepositoryOutPort.updateUser(userModelOptional);
    }

    private Optional<UserModel> findUserByUsernameAndEmail(final Optional<UserModel> userModelOptional) {
        return userModelOptional.map(userModel ->
                this.userRepositoryOutPort.findByUsernameAndEmail(userModel.getUsername(), userModel.getEmail()))
                .stream()
                .filter(user -> user.isPresent())
                .findFirst()
                .orElseThrow(() -> new ResourceExistsException(MessageExceptionType.USER_NOT_FOUND));
    }

    private Optional<UserModel> prepareUser(
            final Optional<UserModel> userModelView,
            final Optional<UserModel> userModelDataBase) {

        final UserModel userModel = new UserModel
                .Builder()
                .username(userModelDataBase.map(UserModel::getUsername).orElse(null))
                .email(userModelDataBase.map(UserModel::getEmail).orElse(null))
                .password(userModelView.map(UserModel::getPassword).orElse(null))
                .status(userModelDataBase.map(UserModel::getStatusType).map(StatusType::getCode).orElse(null))
                .id(userModelDataBase.map(UserModel::getId).orElse(null))
                .creationDate(userModelDataBase.map(UserModel::getCreationDate).orElse(null))
                .lastUpdateDate(userModelDataBase.map(UserModel::getLastUpdateDate).orElse(null))
                .build();

        return Optional.of(userModel);
    }
}
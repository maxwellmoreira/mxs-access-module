package com.mxs.domain.user.usecase.delete;

import com.mxs.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface DeleteUseCase {
    public void removeUser(final List<Optional<UserModel>> userModelOptionalList);
}
package com.mxs.domain.user.usecase.create;

import com.mxs.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface CreateUseCase {
    public void createUser(final List<Optional<UserModel>> userModelOptionalList);
}
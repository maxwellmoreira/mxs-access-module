package com.mxs.domain.user.usecase.read;

import com.mxs.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ReadUseCase {
    public List<Optional<UserModel>> readUser(final Optional<UserModel> userModelOptional);
}

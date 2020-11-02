package com.mxs.domain.user.usecase.update;

import com.mxs.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UpdateUseCase {
    public void updateUser(final List<Optional<UserModel>> userModelOptionalList);
}

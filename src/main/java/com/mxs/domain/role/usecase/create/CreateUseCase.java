package com.mxs.domain.role.usecase.create;

import java.util.List;
import java.util.Optional;

public interface CreateUseCase {
    public void createGroup(final List<Optional<GroupModel>> groupModelOptionalList);
}

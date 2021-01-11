package com.mxs.domain.role.usecase.update;

import java.util.List;
import java.util.Optional;

public interface UpdateUseCase {
    public void updateGroup(final List<Optional<GroupModel>> groupModelOptionalList);
}
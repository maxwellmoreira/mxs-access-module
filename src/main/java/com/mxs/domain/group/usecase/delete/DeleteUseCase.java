package com.mxs.domain.group.usecase.delete;

import java.util.List;
import java.util.Optional;

public interface DeleteUseCase {
    public void removeGroup(final List<Optional<GroupModel>> groupModelOptionalList);
}

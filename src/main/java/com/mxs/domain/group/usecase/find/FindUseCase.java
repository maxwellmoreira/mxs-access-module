package com.mxs.domain.group.usecase.find;

import java.util.List;
import java.util.Optional;

public interface FindUseCase {
    public List<Optional<GroupModel>> findGroup(final Optional<GroupModel> groupModelOptional);
}
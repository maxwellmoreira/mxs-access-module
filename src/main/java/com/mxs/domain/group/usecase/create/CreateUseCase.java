package com.mxs.domain.group.usecase.create;

import com.mxs.model.GroupModel;

import java.util.List;
import java.util.Optional;

public interface CreateUseCase {
    public void createGroup(final List<Optional<GroupModel>> groupModelOptionalList);
}
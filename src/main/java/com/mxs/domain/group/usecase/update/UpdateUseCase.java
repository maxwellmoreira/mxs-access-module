package com.mxs.domain.group.usecase.update;

import com.mxs.model.GroupModel;

import java.util.List;
import java.util.Optional;

public interface UpdateUseCase {
    public void updateGroup(final List<Optional<GroupModel>> groupModelOptionalList);
}
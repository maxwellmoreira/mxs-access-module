package com.mxs.repository;

import com.mxs.model.UserModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository {
    List<Optional<UserModel>> findByEmailAndUsername(final String email, final String username);
}

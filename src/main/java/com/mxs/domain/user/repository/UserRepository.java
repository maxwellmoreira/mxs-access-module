package com.mxs.domain.user.repository;

import com.mxs.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByUsername(final String username);

    Optional<UserModel> findByUsernameAndEmail(final String username, final String email);
}

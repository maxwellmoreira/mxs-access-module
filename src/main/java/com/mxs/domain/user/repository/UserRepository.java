package com.mxs.domain.user.repository;

import com.mxs.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>, JpaSpecificationExecutor<UserModel> {
    public Optional<UserModel> findByUsername(final String username);
    public Optional<UserModel> findByEmail(final String email);
    public Optional<UserModel> findByUsernameAndEmail(final String username, final String email);
    public Optional<UserModel> findByUsernameAndPassword(final String username, final String password);
    public Optional<UserModel> findByUsernameOrEmail(final String username, final String email);
}

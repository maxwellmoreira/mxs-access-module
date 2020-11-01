package com.mxs.repository;

import com.mxs.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    List<Optional<UserModel>> findByEmailAndUsername(final String email, final String username);
}

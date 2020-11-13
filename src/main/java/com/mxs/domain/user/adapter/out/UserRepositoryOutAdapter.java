package com.mxs.domain.user.adapter.out;

import com.mxs.domain.user.port.out.UserRepositoryOutPort;
import com.mxs.domain.user.repository.UserRepository;
import com.mxs.domain.user.repository.UserSpecificationRepository;
import com.mxs.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryOutAdapter implements UserRepositoryOutPort {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(final Optional<UserModel> userModelOptional) {
        this.userRepository.save(userModelOptional.orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public List<Optional<UserModel>> findUser(final Optional<UserModel> userModelOptional) {
        return this.userRepository
                .findAll(new UserSpecificationRepository(userModelOptional))
                .stream()
                .map(Optional::of)
                .collect(Collectors.toList());
    }

    @Override
    public void updateUser(final Optional<UserModel> userModelOptional) {
        this.userRepository.save(userModelOptional.orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public void removeUser(final Optional<UserModel> userModelOptional) {
        this.userRepository.delete(userModelOptional.orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public Optional<UserModel> findByUsername(final String username) {
        return Optional
                .of(username)
                .map(u -> this.userRepository.findByUsername(u))
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Optional<UserModel> findByUsernameAndEmail(final String username, final String email) {
        return this.userRepository.findByUsernameAndEmail(
                Optional.of(username).orElseThrow(IllegalArgumentException::new),
                Optional.of(email).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public Optional<UserModel> findByUsernameAndPassword(final String username, final String password) {
        return this.userRepository.findByUsernameAndPassword(
                Optional.of(username).orElseThrow(IllegalArgumentException::new),
                Optional.of(password).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public Optional<UserModel> findByEmail(final String email) {
        return Optional
                .of(email)
                .map(e -> this.userRepository.findByEmail(e))
                .orElseThrow(IllegalArgumentException::new);
    }
}
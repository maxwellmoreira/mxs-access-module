package com.mxs.domain.user.adapter.out;

import com.mxs.domain.user.port.out.UserRepositoryOutPort;
import com.mxs.domain.user.repository.UserRepository;
import com.mxs.domain.user.repository.UserSpecificationRepository;
import com.mxs.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryOutAdapter implements UserRepositoryOutPort {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(final UserModel userModel) {
        this.userRepository.save(userModel);
    }

    @Override
    public List<UserModel> findUser(final UserModel userModel) {
        return this.userRepository.findAll(new UserSpecificationRepository(userModel));
    }

    @Override
    public void updateUser(final UserModel userModel) {
        this.userRepository.save(userModel);
    }

    @Override
    public void removeUser(final UserModel userModel) {
        this.userRepository.delete(userModel);
    }

    @Override
    public Optional<UserModel> findByEmail(final String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public Optional<UserModel> findByUsername(final String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public Optional<UserModel> findByUsernameAndPassword(final String username, final String password) {
        return this.userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public Optional<UserModel> findByUsernameAndEmail(final String username, final String email) {
        return this.userRepository.findByUsernameAndEmail(username, email);
    }

    @Override
    public Optional<UserModel> findByUsernameOrEmail(final String username, final String email) {
        return this.userRepository.findByUsernameOrEmail(username, email);
    }
}
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
    public void createUser(final Optional<UserModel> userModelOptional) {
        this.userRepository.save(userModelOptional.get());
    }

    @Override
    public List<Optional<UserModel>> findUser(final Optional<UserModel> userModelOptional) {
        UserSpecificationRepository userSpecificationRepository = new UserSpecificationRepository(userModelOptional.get());
        List<UserModel> userModelList = this.userRepository.findAll(userSpecificationRepository);
        return null;
    }

    @Override
    public void updateUser(final Optional<UserModel> userModelOptional) {
        this.userRepository.save(userModelOptional.get());
    }

    @Override
    public void removeUser(final Optional<UserModel> userModelOptional) {
        this.userRepository.delete(userModelOptional.get());
    }

    @Override
    public Optional<UserModel> findByUsername(final String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public Optional<UserModel> findByUsernameAndEmail(final String username, final String email) {
        return this.userRepository.findByUsernameAndEmail(username, email);
    }
}
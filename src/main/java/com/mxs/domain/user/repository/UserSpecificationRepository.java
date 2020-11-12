package com.mxs.domain.user.repository;

import com.mxs.model.UserModel;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Optional;

public class UserSpecificationRepository implements Specification<UserModel> {

    private UserModel userModel;

    public UserSpecificationRepository(final UserModel userModel) {
        this.userModel = userModel;
    }

    @Override
    public Predicate toPredicate(Root<UserModel> root,
                                 CriteriaQuery<?> criteriaQuery,
                                 CriteriaBuilder criteriaBuilder) {

        Predicate predicate = criteriaBuilder.conjunction();

        Optional.ofNullable(this.userModel.getUsername())
                .stream()
                .findFirst()
                .ifPresent(username -> {
                    if (!username.isBlank())
                        predicate.getExpressions()
                                .add(criteriaBuilder.like(root.get("username"), "%" + this.userModel.getUsername() + "%"));
                });

        Optional.ofNullable(this.userModel.getEmail())
                .stream()
                .findFirst()
                .ifPresent(email -> {
                    if (!email.isBlank())
                        predicate.getExpressions()
                            .add(criteriaBuilder.like(root.get("email"), "%" + this.userModel.getEmail() + "%"));
                });

        Optional.ofNullable(this.userModel.getStatusType().getCode())
                .stream()
                .findFirst()
                .ifPresent(status -> {
                    if (!status.isBlank()) {
                        predicate.getExpressions()
                                .add(criteriaBuilder.equal(root.get("status"), this.userModel.getStatusType().getCode()));
                    }
                });

        return predicate;
    }
}
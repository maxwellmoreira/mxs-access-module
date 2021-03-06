package com.mxs.domain.user.repository;

import com.mxs.factory.type.StatusType;
import com.mxs.model.UserModel;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Optional;

public class UserSpecificationRepository implements Specification<UserModel> {

    private final UserModel userModel;

    public UserSpecificationRepository(final UserModel userModel) {
        this.userModel = userModel;
    }

    @Override
    public Predicate toPredicate(Root<UserModel> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        Predicate predicate = criteriaBuilder.conjunction();

        Optional.ofNullable(userModel)
                .map(UserModel::getUsername)
                .ifPresent(username -> {
                    if (!username.isBlank())
                        predicate.getExpressions()
                                .add(criteriaBuilder.like(root.get("username"), "%" + username + "%"));
                });

        Optional.ofNullable(userModel)
                .map(UserModel::getEmail)
                .ifPresent(email -> {
                    if (!email.isBlank())
                        predicate.getExpressions()
                                .add(criteriaBuilder.like(root.get("email"), "%" + email + "%"));
                });

        Optional.ofNullable(userModel)
                .map(UserModel::getStatusType)
                .map(StatusType::getCode)
                .ifPresent(code -> {
                    if (!code.isBlank())
                        predicate.getExpressions()
                                .add(criteriaBuilder.equal(root.get("status"), code));
                });

        return predicate;
    }
}
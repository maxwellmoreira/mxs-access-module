package com.mxs.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public final class UserRoleKey implements Serializable {
    @Column(name = "user_id")
    private final Long userId;

    @Column(name = "role_id")
    private final Long roleId;

    public UserRoleKey(final Long userId, final Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }
}
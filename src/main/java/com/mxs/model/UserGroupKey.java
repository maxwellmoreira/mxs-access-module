package com.mxs.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserGroupKey implements Serializable {
    @Column(name = "user_id")
    private final Long userId;

    @Column(name = "group_id")
    private final Long groupId;

    public UserGroupKey(final Long userId, final Long groupId) {
        this.userId = userId;
        this.groupId = groupId;
    }
}
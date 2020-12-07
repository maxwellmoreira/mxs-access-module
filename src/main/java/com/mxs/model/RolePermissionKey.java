package com.mxs.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public final class RolePermissionKey implements Serializable {
    @Column(name = "role_id")
    private final Long roleId;
    @Column(name = "permission_id")
    private final Long permissionId;

    public RolePermissionKey(final Long roleId, final Long permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }
}
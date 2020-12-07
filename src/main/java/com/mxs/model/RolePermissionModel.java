package com.mxs.model;

import com.mxs.factory.type.StatusType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "role_permission")
public final class RolePermissionModel {
    @EmbeddedId
    private RolePermissionKey rolePermissionKey;
    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private RoleModel roleModel;
    @ManyToOne
    @MapsId("permissionId")
    @JoinColumn(name = "permission_id")
    private PermissionModel permissionModel;
    @CreationTimestamp
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", nullable = false, updatable = false)
    private Date creationDate;
    @UpdateTimestamp
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update_date", nullable = false)
    private Date lastUpdateDate;
    @Column(name = "status_type", nullable = false)
    private String status;
    @Transient
    private StatusType statusType;

    public RolePermissionModel() { }

    public RolePermissionModel(final RoleModel roleModel,
                               final PermissionModel permissionModel,
                               final StatusType statusType) {
        this.roleModel = roleModel;
        this.permissionModel = permissionModel;
        this.rolePermissionKey = new RolePermissionKey(roleModel.getId(), permissionModel.getId());
        this.statusType = statusType;
        this.status = statusType.getCode();
    }

    @PrePersist
    public void onPrePersist() {
        this.status = StatusType.ACTIVE.getCode();
    }
    @PostLoad
    void fillTransient() {
        this.statusType = StatusType.of(status);
    }

    public RoleModel getRoleModel() { return roleModel; }
    public PermissionModel getPermissionModel() { return permissionModel; }
    public Date getCreationDate() { return creationDate; }
    public Date getLastUpdateDate() { return lastUpdateDate; }
    public StatusType getStatusType() { return statusType; }
}
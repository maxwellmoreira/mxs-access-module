package com.mxs.model;

import com.mxs.factory.type.StatusType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "user_role")
public final class UserRoleModel {
    @EmbeddedId
    private UserRoleKey userRoleKey;
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private UserModel userModel;
    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private RoleModel roleModel;
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

    public UserRoleModel() { }

    public UserRoleModel(final UserModel userModel,
                         final RoleModel roleModel,
                         final StatusType statusType) {
        this.userModel = userModel;
        this.roleModel = roleModel;
        this.userRoleKey = new UserRoleKey(userModel.getId(), roleModel.getId());
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

    public UserModel getUserModel() { return userModel; }
    public RoleModel getRoleModel() { return roleModel; }
    public Date getCreationDate() { return creationDate; }
    public Date getLastUpdateDate() { return lastUpdateDate; }
    public StatusType getStatusType() { return statusType; }
}
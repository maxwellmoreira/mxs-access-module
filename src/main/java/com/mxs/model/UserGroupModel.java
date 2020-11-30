package com.mxs.model;

import com.mxs.factory.type.StatusType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "user_group")
public final class UserGroupModel {

    @EmbeddedId
    private UserGroupKey userGroupKey;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private UserModel userModel;

    @ManyToOne
    @MapsId("groupId")
    @JoinColumn(name = "group_id")
    private GroupModel groupModel;

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

    public UserGroupModel() { }

    public UserGroupModel(final UserGroupKey userGroupKey,
                          final UserModel userModel,
                          final GroupModel groupModel,
                          final Date creationDate,
                          final Date lastUpdateDate,
                          final String status,
                          final StatusType statusType) {
        this.userGroupKey = userGroupKey;
        this.userModel = userModel;
        this.groupModel = groupModel;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.status = status;
        this.statusType = statusType;
    }

    @PrePersist
    public void onPrePersist() {
        this.status = StatusType.ACTIVE.getCode();
    }

    @PostLoad
    void fillTransient() {
        this.statusType = StatusType.of(status);
    }

    public Date getCreationDate() { return creationDate; }

    public Date getLastUpdateDate() { return lastUpdateDate; }

    public StatusType getStatusType() { return statusType; }
}
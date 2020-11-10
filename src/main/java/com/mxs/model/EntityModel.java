package com.mxs.model;

import com.mxs.factory.type.StatusType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class EntityModel {
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    @CreationTimestamp
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creationDate", nullable = false)
    private Date creationDate;
    @UpdateTimestamp
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastUpdateDate", nullable = false)
    private Date lastUpdateDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "statusType", nullable = false)
    private StatusType statusType;

    public EntityModel() {
    }

    public Long getId() {
        return id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public StatusType getStatusType() {
        return statusType;
    }
}
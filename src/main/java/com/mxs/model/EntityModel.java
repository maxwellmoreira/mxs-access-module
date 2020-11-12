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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    public EntityModel() {
    }

    public EntityModel(final Long id,
                       final Date creationDate,
                       final Date lastUpdateDate,
                       final StatusType statusType,
                       final String status) {
        this.id = id;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.statusType = statusType;
        this.status = status;
    }

    @PrePersist
    public void onPrePersist() {
        this.status = StatusType.ACTIVE.getCode();
    }

    @PostLoad
    void fillTransient() {
        this.statusType = StatusType.of(status);
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
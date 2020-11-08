package com.mxs.model;

import com.mxs.factory.type.StatusType;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public abstract class EntityModel {
    @Column(name = "id", nullable=false)
    private Long id;
    @Column(name = "creationDate", nullable=false)
    private LocalDate creationDate;
    @Column(name = "lastUpdateDate", nullable=false)
    private LocalDate lastUpdateDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "statusType", nullable=false)
    private StatusType statusType;

    public EntityModel() {
    }

    public Long getId() {
        return id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public StatusType getStatusType() {
        return statusType;
    }
}
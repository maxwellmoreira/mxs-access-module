package com.mxs.model;

import com.mxs.factory.type.StatusType;

import java.time.LocalDate;

public class EntityModel {
    private Long id;
    private LocalDate creationDate;
    private LocalDate lastUpdateDate;
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
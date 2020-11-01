package com.mxs.model;

import com.mxs.type.StatusType;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

public class EntityModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "creation_date")
    private LocalDate creationDate;
    @Column(name = "last_update_date")
    private LocalDate lastUpdateDate;
    @Column(name = "status")
    private StatusType statusType;

    public EntityModel() { }

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
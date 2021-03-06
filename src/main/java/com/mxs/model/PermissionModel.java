package com.mxs.model;

import com.mxs.factory.type.StatusType;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity(name = "permission")
public final class PermissionModel extends EntityModel {

    @Column(name = "code", nullable = false, unique = true)
    private String code;
    @Column(name = "description", nullable = false)
    private String description;

    public PermissionModel() { super(); }

    public String getCode() { return code; }

    public String getDescription() { return description; }

    public StatusType getStatusType() { return super.getStatusType(); }

    private PermissionModel(final Builder builder) {
        super(builder.id, builder.creationDate, builder.lastUpdateDate, StatusType.of(builder.status), builder.status);
        this.code = builder.code;
        this.description = builder.description;
    }

    public final static class Builder {

        private Long id;
        private Date creationDate;
        private Date lastUpdateDate;
        private String status;
        private String code;
        private String description;

        public Builder() { }

        public Builder id(final Long id) {
            this.id = id;
            return this;
        }

        public Builder creationDate(final Date creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public Builder lastUpdateDate(final Date lastUpdateDate) {
            this.lastUpdateDate = lastUpdateDate;
            return this;
        }

        public Builder status(final String status) {
            this.status = status;
            return this;
        }

        public Builder username(final String code) {
            this.code = code;
            return this;
        }

        public Builder description(final String description) {
            this.description = description;
            return this;
        }

        public PermissionModel build() {
            return new PermissionModel(this);
        }
    }
}
package com.mxs.model;

import com.mxs.factory.type.StatusType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

@Entity(name = "user")
public final class UserModel extends EntityModel {

    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "userModel")
    private Set<UserRoleModel> userRoleModelSet;

    public UserModel() { super(); }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() { return password; }

    public Set<UserRoleModel> getUserRoleModelSet() { return userRoleModelSet; }

    public StatusType getStatusType() { return super.getStatusType(); }

    private UserModel(final Builder builder) {
        super(builder.id, builder.creationDate, builder.lastUpdateDate, StatusType.of(builder.status), builder.status);
        this.username = builder.username;
        this.email = builder.email;
        this.password = builder.password;
    }

    public final static class Builder {

        private Long id;
        private Date creationDate;
        private Date lastUpdateDate;
        private String status;
        private String username;
        private String email;
        private String password;

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

        public Builder username(final String username) {
            this.username = username;
            return this;
        }

        public Builder email(final String email) {
            this.email = email;
            return this;
        }

        public Builder password(final String password) {
            this.password = password;
            return this;
        }

        public UserModel build() { return new UserModel(this); }
    }
}
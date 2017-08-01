package com.pandian.learning.springboot.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by khjg232 on 27/11/2016.
 */
@MappedSuperclass
@Data
public class ApplicationAudit implements Serializable {
    @CreationTimestamp
    @Column(name = "CREATED_TIME",updatable = false)
    private Timestamp createTime;

    @UpdateTimestamp
    @Column(name = "MODIFIED_TIME")
    private Timestamp modifiedTime;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

    @Column(name = "CREATED_BY",updatable = false)
    private String createdBy;

    @PrePersist
    public void prePersist() {
        String createdBy = getUsernameOfAuthenticatedUser();
        this.createdBy = createdBy;
        this.modifiedBy = createdBy;
    }

    @PreUpdate
    public void preUpdate() {
        String modifiedBy = getUsernameOfAuthenticatedUser();
        this.modifiedBy = modifiedBy;
    }

    private String getUsernameOfAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        return authentication.getPrincipal().toString();
    }
}

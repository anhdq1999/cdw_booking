package com.booking.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@EntityListeners({AuditingEntityListener.class})
@MappedSuperclass
@Data
public abstract class AbstractEntity {

    @Column(name = "created_by")
    String createdBy;

    @Column(name = "modified_by")
    String modifiedBy;

    @CreatedDate
    @Column(name = "created_date",insertable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date createdDate;

    @LastModifiedDate
    @Column(name = "modified_date",insertable = false, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    Date modifiedDate;
}

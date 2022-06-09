package com.example.cdweb.HotelBookingAPI.entity;

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
@Getter
@Setter
public abstract class AbstractEntity {
    @Column(name = "createdBy")
    String createdBy;
    @Column(name = "modifiedBy")
    String modifiedBy;
    @CreatedDate
    @Column(name = "createdDate",insertable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date createdDate;
    @LastModifiedDate
    @Column(name = "modifiedDate",insertable = false, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    Date modifiedDate;
}

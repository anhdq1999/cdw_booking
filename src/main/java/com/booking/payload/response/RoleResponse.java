package com.booking.payload.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Builder
@Getter
@Setter
public class RoleResponse {
    Long id;
    String name;
    String code;
    Date createdDate;
    Date modifiedDate;
}

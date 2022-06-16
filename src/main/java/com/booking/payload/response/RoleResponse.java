package com.booking.payload.response;

import com.booking.entity.ERole;
import lombok.*;

import javax.persistence.Column;
import java.util.Date;

@Builder
@Data
public class RoleResponse {
    Long id;
    ERole name;
}

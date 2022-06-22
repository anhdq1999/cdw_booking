package com.booking.payload.response;

import com.booking.entity.ERole;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoleResponse {
    Long id;
    ERole name;
}

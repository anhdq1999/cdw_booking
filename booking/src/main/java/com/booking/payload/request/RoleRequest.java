package com.booking.payload.request;

import com.booking.entity.ERole;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class RoleRequest {
    ERole name;
}

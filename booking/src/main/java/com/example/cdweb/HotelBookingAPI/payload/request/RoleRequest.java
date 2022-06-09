package com.example.cdweb.HotelBookingAPI.payload.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RoleRequest {
    String name;
    String code;
}

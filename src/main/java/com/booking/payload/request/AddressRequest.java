package com.booking.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class AddressRequest {
    private String country;
    private String province;
    private String district;
    private String ward;
    private String street;
    private String googleAddress;

}

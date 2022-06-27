package com.booking.payload.response;

import lombok.Builder;
import lombok.Data;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Builder
public class AddressResponse {
    private Long id;
    private String country;
    private String province;
    private String district;
    private String ward;
    private String street;
    private String googleAddress;
}

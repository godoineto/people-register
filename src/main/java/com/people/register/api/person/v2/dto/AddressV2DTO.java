package com.people.register.api.person.v2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressV2DTO {

    private String id;
    private String zipCode;
    private String street;
    private Integer number;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
}

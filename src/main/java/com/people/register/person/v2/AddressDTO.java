package com.people.register.person.v2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    private String zipCode;
    private String street;
    private Integer number;
    private String neighborhood;
    private String city;
    private String country;
}

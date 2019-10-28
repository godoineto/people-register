package com.people.register.api.address.model;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Address {

    private String id;
    private String zipCode;
    private String street;
    private Integer number;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
}

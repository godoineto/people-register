package com.people.register.person.v2.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AddressDTO {

    @NotBlank(message = "{address.zipCode.invalid}")
    private String zipCode;
    @NotBlank(message = "{address.street.invalid}")
    private String street;
    @NotNull(message = "{address.number.invalid}")
    private Integer number;
    @NotBlank(message = "{address.neighborhood.invalid}")
    private String neighborhood;
    @NotBlank(message = "{address.city.invalid}")
    private String city;
    @NotBlank(message = "{address.state.invalid}")
    private String state;
    @NotBlank(message = "{address.country.invalid}")
    private String country;
}

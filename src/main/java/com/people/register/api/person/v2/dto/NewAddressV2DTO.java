package com.people.register.api.person.v2.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class NewAddressV2DTO {

    @NotBlank(message = "{address.zipCode.invalid}")
    @Pattern(regexp = "(^\\d{5}\\x2D\\d{3}$)", message = "{address.zipCode.invalid}")
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

package com.people.register.person.v2.dto;

import com.people.register.person.v1.dto.PersonV1DTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
public class PersonV2DTO extends PersonV1DTO {

    @NotEmpty(message = "{person.address.invalid}")
    private List<@Valid AddressDTO> address;
}

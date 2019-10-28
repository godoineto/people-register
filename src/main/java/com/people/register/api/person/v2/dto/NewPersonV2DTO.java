package com.people.register.api.person.v2.dto;

import com.people.register.api.address.v2.dto.NewAddressV2DTO;
import com.people.register.api.person.v1.dto.NewPersonV1DTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
public class NewPersonV2DTO extends NewPersonV1DTO {

    @NotEmpty(message = "{person.address.invalid}")
    private List<@Valid NewAddressV2DTO> addresses;
}

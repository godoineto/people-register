package com.people.register.api.person.v2.dto;

import com.people.register.api.person.v1.dto.PersonV1DTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonV2DTO extends PersonV1DTO {
    private List<AddressV2DTO> addresses;
}

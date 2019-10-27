package com.people.register.api.person.v2.dto;

import com.people.register.api.person.v1.dto.PersonV1DTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonV2DTO extends PersonV1DTO {
    private String addresses;
}

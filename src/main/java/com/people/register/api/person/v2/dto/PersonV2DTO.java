package com.people.register.api.person.v2.dto;

import com.people.register.api.person.model.Gender;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PersonV2DTO {

    private String id;
    private String name;
    private Gender gender;
    private String email;
    private Date birth;
    private String placeOfBirth;
    private String nationality;
    private String cpf;
    private String addresses;
}

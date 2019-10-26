package com.people.register.person.v2;

import com.people.register.person.model.Gender;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PersonDTO {

    private String name;
    private Gender gender;
    private String email;
    private Date birth;
    private String placeOfBirth;
    private String nationality;
    private String cpf;

    private List<AddressDTO> address;
}

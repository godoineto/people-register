package com.people.register.person.v1.dto;

import com.people.register.person.model.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
public class PersonV1DTO {

    @NotBlank(message = "{person.name.invalid}")
    private String name;
    private Gender gender;
    @Email(message = "{person.email.invalid}")
    private String email;
    @Past(message = "{person.birth.invalid}")
    @NotNull(message = "{person.birth.invalid}")
    private Date birth;
    private String placeOfBirth;
    private String nationality;
    @Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)", message = "{person.cpf.invalid}")
    private String cpf;
}

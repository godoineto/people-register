package com.people.register.api.person.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document("person")
public class Person {

    @Id
    private String id;
    @Indexed(name = "name")
    private String name;
    private Gender gender;
    private String email;
    private Date birth;
    private String placeOfBirth;
    private String nationality;
    private String cpf;


}

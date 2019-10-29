package com.people.register.api.person.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

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
    @Indexed(name = "cpf")
    private String cpf;
    private List<Address> addresses;

    private Date createdAt;
    private Date lastUpdate;

    public Person() {
        createdAt = new Date();
    }

    public Person update(Person person) {
        this.name = person.getName();
        this.gender = person.getGender();
        this.email = person.getEmail();
        this.birth = person.getBirth();
        this.placeOfBirth = person.getPlaceOfBirth();
        this.nationality = person.getNationality();
        this.cpf = person.getCpf();
        this.addresses = person.getAddresses();
        this.lastUpdate = new Date();
        return this;
    }
}

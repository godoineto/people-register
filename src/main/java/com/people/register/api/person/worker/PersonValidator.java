package com.people.register.api.person.worker;

import com.people.register.api.person.exception.CPFIsAlreadyInUseException;
import com.people.register.api.person.model.Person;
import com.people.register.api.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PersonValidator {

    @Autowired
    private PersonRepository repository;

    public void validate(Person person) {
        Objects.requireNonNull(person);
        repository.findByCpf(person.getCpf()).ifPresent(ignored -> {
            throw new CPFIsAlreadyInUseException();
        });
    }
}

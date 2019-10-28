package com.people.register.api.person.worker;

import com.people.register.api.person.model.Person;
import com.people.register.api.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonCreator {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private PersonValidator validator;

    public Person create(Person newPerson) {
        validator.validate(newPerson);
        return repository.save(newPerson);
    }
}

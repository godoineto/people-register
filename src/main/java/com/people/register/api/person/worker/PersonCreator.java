package com.people.register.api.person.worker;

import com.people.register.api.person.model.Person;
import com.people.register.api.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonCreator {

    @Autowired
    private PersonRepository repository;

    public Person create(Person newPerson) {
        //TODO: validate person
        return repository.save(newPerson);
    }
}

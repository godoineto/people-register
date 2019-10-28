package com.people.register.api.person.worker;

import com.people.register.api.person.exception.PersonNotFoundException;
import com.people.register.api.person.model.Person;
import com.people.register.api.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonUpdater {

    @Autowired
    private PersonRepository repository;

    public Person update(String id, Person newPerson) {
        return repository.findById(id)
                .map(person ->
                    repository.save(person.update(newPerson)))
                .orElseThrow(PersonNotFoundException::new);
    }
}

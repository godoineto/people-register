package com.people.register.api.person.worker;

import com.people.register.api.person.exception.PersonNotFoundException;
import com.people.register.api.person.model.Person;
import com.people.register.api.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonLoader {

    @Autowired
    private PersonRepository repository;

    public List<Person> list() {
        return repository.findAll();
    }

    public Person find(String id) {
        return repository.findById(id).orElseThrow(PersonNotFoundException::new);
    }
}

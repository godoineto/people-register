package com.people.register.api.person.worker;

import com.people.register.api.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonDeleter {

    @Autowired
    private PersonRepository repository;

    public void delete(String id) {
        repository.findById(id)
                .ifPresent(person -> repository.delete(person));
    }
}

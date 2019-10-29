package com.people.register.api.person.repository;

import com.people.register.api.person.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface PersonRepository extends MongoRepository<Person, String> {

    @Query("{'cpf': ?0}")
    Optional<Person> findByCpf(String cpf);
}

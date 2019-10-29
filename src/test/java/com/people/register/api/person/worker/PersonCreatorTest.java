package com.people.register.api.person.worker;


import com.people.register.api.person.exception.CPFIsAlreadyInUseException;
import com.people.register.api.person.model.Person;
import com.people.register.api.person.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class PersonCreatorTest {

    @Mock
    private PersonValidator validator;

    @Mock
    private PersonRepository repository;

    @InjectMocks
    private PersonCreator creator;

    @Test
    public void shouldNotCreatePersonWhenHasNullReference() {
        doThrow(NullPointerException.class).when(validator).validate(null);
        assertThrows(NullPointerException.class, () -> creator.create(null));
        verify(validator, times(1)).validate(null);
        verify(repository, never()).save(null);
    }

    @Test
    public void shouldNotCreatePersonWhenAlreadyHasAnotherPersonWithSameCPF() {
        Person person = new Person();
        person.setCpf("000.000.000-00");

        doThrow(CPFIsAlreadyInUseException.class).when(validator).validate(person);

        assertThrows(CPFIsAlreadyInUseException.class, () -> creator.create(person));
        verify(validator, times(1)).validate(person);
        verify(repository, never()).save(person);
    }

    @Test
    public void shouldCreatePersonCorrectly() {
        Person person = new Person();
        person.setCpf("000.000.000.-11");
        person.setName("Name");
        person.setBirth(new Date());
        person.setEmail("person@email.com");

        creator.create(person);

        verify(validator, times(1)).validate(person);
        verify(repository, times(1)).save(person);
    }
}
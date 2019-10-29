package com.people.register.api.person.worker;

import com.people.register.api.person.exception.PersonNotFoundException;
import com.people.register.api.person.model.Person;
import com.people.register.api.person.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class PersonUpdaterTest {

    @Mock
    private PersonRepository repository;

    @InjectMocks
    private PersonUpdater updater;

    @Test
    public void shouldThrowPersonNotFoundExceptionWhenTryUpdatePersonThatNotExists() {
        Person person = new Person();
        person.setId("5db753ad8e56c24d7186d736");

        when(repository.findById(person.getId())).thenReturn(Optional.empty());

        assertThrows(PersonNotFoundException.class, () -> updater.update(person.getId(), person));
    }

    @Test
    public void shouldUpdatePersonAttributesCorrectly() {
        String id = "5db753ad8e56c24d7186d736";
        Person oldPerson = new Person();
        oldPerson.setId(id);
        oldPerson.setName("Old Person");

        Person newPerson = new Person();
        newPerson.setId(id);
        newPerson.setName("New Person");

        when(repository.findById(id)).thenReturn(Optional.of(oldPerson));
        when(repository.save(oldPerson)).thenReturn(oldPerson);

        updater.update(id, newPerson);

        verify(repository, times(1)).save(oldPerson);
        assertEquals(newPerson.getName(), oldPerson.getName());
    }
}
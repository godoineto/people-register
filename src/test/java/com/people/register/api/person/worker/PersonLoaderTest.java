package com.people.register.api.person.worker;

import com.people.register.api.person.exception.PersonNotFoundException;
import com.people.register.api.person.model.Person;
import com.people.register.api.person.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class PersonLoaderTest {

    @Mock
    private PersonRepository repository;

    @InjectMocks
    private PersonLoader loader;

    @Test
    public void shouldLoaderListOfPeopleCorrectly() {
        when(repository.findAll()).thenReturn(Collections.singletonList(new Person()));

        loader.list();

        verify(repository, times(1)).findAll();
    }

    @Test
    public void shouldLoaderPersonCorrectly() {
        Person person = new Person();
        String id = "5db753ad8e56c24d7186d736";

        when(repository.findById(id)).thenReturn(Optional.of(person));

        loader.find(id);

        verify(repository, times(1)).findById(id);
    }

    @Test
    public void shouldThrowPersonNotFoundExceptionWhenHasNoOneAtDatabase() {
        Person person = new Person();
        String id = "5db753ad8e56c24d7186d736";

        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(PersonNotFoundException.class, () -> loader.find(id));
    }
}
package com.people.register.api.person.worker;

import com.people.register.api.person.model.Person;
import com.people.register.api.person.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class PersonDeleterTest {

    @Mock
    private PersonRepository repository;

    @InjectMocks
    private PersonDeleter deleter;

    @Test
    public void shouldNotDeletePersonWhenNotFoundAny() {
        when(repository.findById("5db753ad8e56c24d7186d736")).thenReturn(Optional.empty());

        deleter.delete("5db753ad8e56c24d7186d736");

        verify(repository, never()).delete(any());
    }

    @Test
    public void shouldDeletePersonCorrectly() {
        Person person = new Person();
        person.setId("5db753ad8e56c24d7186d736");

        when(repository.findById("5db753ad8e56c24d7186d736")).thenReturn(Optional.of(person));

        deleter.delete("5db753ad8e56c24d7186d736");

        verify(repository, times(1)).delete(person);
    }
}
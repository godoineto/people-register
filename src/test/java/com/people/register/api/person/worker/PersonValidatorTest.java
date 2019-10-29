package com.people.register.api.person.worker;


import com.people.register.api.person.exception.CPFIsAlreadyInUseException;
import com.people.register.api.person.model.Person;
import com.people.register.api.person.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class PersonValidatorTest {


    @Mock
    private PersonRepository repository;


    @InjectMocks
    private PersonValidator validator;

    @Test
    public void shouldThrowNullPointerExceptionWhenHasNullReference() {
        assertThrows(NullPointerException.class, () -> validator.validate(null));
    }

    @Test
    public void shouldThrowCPFIsAlreadyInUseExceptionWhenAlreadyHasAnotherPersonWithSameCPF() {
        Person person = new Person();
        person.setCpf("000.000.000-11");
        Person anotherPerson = new Person();

        when(repository.findByCpf(person.getCpf())).thenReturn(Optional.of(anotherPerson));

        assertThrows(CPFIsAlreadyInUseException.class, () -> validator.validate(person));

        verify(repository, times(1)).findByCpf(person.getCpf());
    }

    @Test
    public void shouldValidatePersonCorrectly() {
        Person person = new Person();
        person.setCpf("000.000.000-11");

        when(repository.findByCpf(person.getCpf())).thenReturn(Optional.empty());

        validator.validate(person);

        verify(repository, times(1)).findByCpf(person.getCpf());
    }
}
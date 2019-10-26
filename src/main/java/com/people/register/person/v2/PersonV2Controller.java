package com.people.register.person.v2;

import com.people.register.person.model.Gender;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("v2/person")
public class PersonV2Controller {

    @GetMapping
    public List<PersonDTO> list() {
        val karol = new PersonDTO();
        karol.setName("Karol G Siegel");
        karol.setGender(Gender.FEMALE);
        karol.setEmail("karolgs@hotmail.com");
        karol.setNationality("Brasileira");
        karol.setPlaceOfBirth("Palhoça");
        karol.setCpf("000.000.000-00");
        karol.setBirth(new Date());
        karol.setAddress(new ArrayList<>());
        val karolAddress = new AddressDTO();
        karolAddress.setCity("Palhoça");
        karolAddress.setNeighborhood("Pedra Branca");
        karolAddress.setCountry("Brasil");
        karolAddress.setNumber(347);
        karolAddress.setStreet("Rua da Pedra");
        karolAddress.setZipCode("88137-072");
        karol.getAddress().add(karolAddress);
        val neto = new PersonDTO();
        neto.setName("Neto Godoi");
        neto.setGender(Gender.MALE);
        neto.setEmail("netogodoi.dev@gmail.com");
        neto.setNationality("Brasileiro");
        neto.setPlaceOfBirth("Lages");
        neto.setCpf("089.457.839-11");
        neto.setBirth(new Date());
        val lia = new PersonDTO();
        lia.setName("Lia Siegel Godoi");
        lia.setGender(Gender.FEMALE);
        lia.setEmail("chowchowlia@gmail.com");
        lia.setNationality("Brasileira");
        lia.setPlaceOfBirth("Palhoça");
        lia.setCpf("000.000.000-00");
        lia.setBirth(new Date());
        return Arrays.asList(karol, neto, lia);
    }
}

package com.people.register.person.v1;

import com.people.register.person.model.Gender;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("v1/person")
public class PersonController {

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

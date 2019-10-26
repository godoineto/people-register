package com.people.register.api.person.v1;

import com.people.register.api.person.model.Gender;
import com.people.register.api.person.v1.dto.NewPersonV1DTO;
import com.people.register.config.GeneralController;
import io.swagger.annotations.Api;
import lombok.val;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("v1/person")
@Api("Person V1")
public class PersonV1Controller implements GeneralController {


    @PostMapping
    public void add(@RequestBody @Valid NewPersonV1DTO newPerson) {
        System.out.println(newPerson);
    }

    @GetMapping
    public List<NewPersonV1DTO> list() {
        val karol = new NewPersonV1DTO();
        karol.setName("Karol G Siegel");
        karol.setGender(Gender.FEMALE);
        karol.setEmail("karolgs@hotmail.com");
        karol.setNationality("Brasileira");
        karol.setPlaceOfBirth("Palhoça");
        karol.setCpf("000.000.000-00");
        karol.setBirth(new Date());
        val neto = new NewPersonV1DTO();
        neto.setName("Neto Godoi");
        neto.setGender(Gender.MALE);
        neto.setEmail("netogodoi.dev@gmail.com");
        neto.setNationality("Brasileiro");
        neto.setPlaceOfBirth("Lages");
        neto.setCpf("089.457.839-11");
        neto.setBirth(new Date());
        val lia = new NewPersonV1DTO();
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

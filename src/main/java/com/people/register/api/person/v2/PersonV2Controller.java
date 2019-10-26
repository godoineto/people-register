package com.people.register.api.person.v2;

import com.people.register.api.person.model.Gender;
import com.people.register.api.person.v2.dto.NewPersonV2DTO;
import com.people.register.api.person.v2.dto.PersonV2DTO;
import com.people.register.config.GeneralController;
import io.swagger.annotations.Api;
import lombok.val;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("v2/person")
@Api(value = "Person V2")
public class PersonV2Controller implements GeneralController {

    @PostMapping
    public void add(@RequestBody @Valid NewPersonV2DTO newPerson) {

    }

    @GetMapping
    public List<PersonV2DTO> list() {
        val karol = new PersonV2DTO();
        karol.setName("Karol G Siegel");
        karol.setGender(Gender.FEMALE);
        karol.setEmail("karolgs@hotmail.com");
        karol.setNationality("Brasileira");
        karol.setPlaceOfBirth("Palhoça");
        karol.setCpf("000.000.000-00");
        karol.setBirth(new Date());
        karol.setAddresses("http://localhost:8080/api/v2/person/123456/address");
        val neto = new PersonV2DTO();
        neto.setName("Neto Godoi");
        neto.setGender(Gender.MALE);
        neto.setEmail("netogodoi.dev@gmail.com");
        neto.setNationality("Brasileiro");
        neto.setPlaceOfBirth("Lages");
        neto.setCpf("089.457.839-11");
        neto.setBirth(new Date());
        val lia = new PersonV2DTO();
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

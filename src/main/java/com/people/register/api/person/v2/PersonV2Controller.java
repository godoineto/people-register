package com.people.register.api.person.v2;

import com.people.register.api.address.v2.dto.AddressV2DTO;
import com.people.register.api.person.model.Person;
import com.people.register.api.person.v2.dto.NewPersonV2DTO;
import com.people.register.api.person.v2.dto.PersonV2DTO;
import com.people.register.api.person.worker.PersonCreator;
import com.people.register.api.person.worker.PersonLoader;
import com.people.register.config.GeneralController;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.lang.reflect.Type;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("v2/person")
@Api(value = "Person V2")
public class PersonV2Controller implements GeneralController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PersonCreator creator;

    @Autowired
    private PersonLoader loader;

    @PostMapping
    public PersonV2DTO add(@RequestBody @Valid NewPersonV2DTO newPerson) {
        PersonV2DTO result = mapper.map(creator.create(mapper.map(newPerson, Person.class)), PersonV2DTO.class);
        result.setAddresses(linkTo(PersonV2Controller.class).slash(result.getId()).withSelfRel().getHref());
        return result;
    }

    @GetMapping("{personId}/addresses")
    public List<AddressV2DTO> getAddressForPerson(@PathParam("personId") String personId) {
        return null;
    }

    @GetMapping
    public List<PersonV2DTO> list() {
        Type listType = new TypeToken<List<PersonV2DTO>>(){}.getType();
        return mapper.map(loader.list(), listType);
    }
}

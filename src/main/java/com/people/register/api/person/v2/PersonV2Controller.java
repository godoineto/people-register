package com.people.register.api.person.v2;

import com.people.register.api.person.model.Person;
import com.people.register.api.person.v2.dto.NewPersonV2DTO;
import com.people.register.api.person.v2.dto.PersonV2DTO;
import com.people.register.api.person.worker.PersonCreator;
import com.people.register.api.person.worker.PersonDeleter;
import com.people.register.api.person.worker.PersonLoader;
import com.people.register.api.person.worker.PersonUpdater;
import com.people.register.config.GeneralController;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("v2/person")
@Api(value = "Person V2")
public class PersonV2Controller implements GeneralController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PersonCreator creator;

    @Autowired
    private PersonUpdater updater;

    @Autowired
    private PersonLoader loader;

    @Autowired
    private PersonDeleter deleter;

    @PostMapping
    public PersonV2DTO add(@RequestBody @Valid NewPersonV2DTO newPerson) {
        return mapper.map(creator.create(mapper.map(newPerson, Person.class)), PersonV2DTO.class);
    }

    @PutMapping("{id}")
    public PersonV2DTO edit(@PathVariable("id") String id, @RequestBody @Valid NewPersonV2DTO newPerson) {
        return mapper.map(updater.update(id, mapper.map(newPerson, Person.class)), PersonV2DTO.class);
    }

    @GetMapping("{id}")
    public PersonV2DTO load(@PathVariable("id") String id) {
        return mapper.map(loader.find(id), PersonV2DTO.class);
    }

    @GetMapping
    public List<PersonV2DTO> list() {
        Type listType = new TypeToken<List<PersonV2DTO>>(){}.getType();
        return mapper.map(loader.list(), listType);
    }
}

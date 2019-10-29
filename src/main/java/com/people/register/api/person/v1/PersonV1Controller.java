package com.people.register.api.person.v1;

import com.people.register.api.person.model.Person;
import com.people.register.api.person.v1.dto.NewPersonV1DTO;
import com.people.register.api.person.v1.dto.PersonV1DTO;
import com.people.register.api.person.worker.PersonCreator;
import com.people.register.api.person.worker.PersonDeleter;
import com.people.register.api.person.worker.PersonLoader;
import com.people.register.api.person.worker.PersonUpdater;
import com.people.register.config.GeneralController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("api/v1/person")
@Api(description = "API to add, edit, delete and get people")
public class PersonV1Controller implements GeneralController {

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
    @ApiOperation(value = "Service to add person")
    public PersonV1DTO add(@RequestBody @Valid NewPersonV1DTO newPerson) {
        return mapper.map(
                creator.create(
                        mapper.map(newPerson, Person.class)),
                PersonV1DTO.class);
    }

    @PutMapping("{id}")
    @ApiOperation(value = "Service to update person info")
    public PersonV1DTO edit(@PathVariable("id") String id, @RequestBody @Valid NewPersonV1DTO newPerson) {
        return mapper.map(updater.update(id, mapper.map(newPerson, Person.class)), PersonV1DTO.class);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Service to load a single person")
    public PersonV1DTO load(@PathVariable("id") String id) {
        return mapper.map(loader.find(id), PersonV1DTO.class);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Service to delete a single person")
    public void delete(@PathVariable("id") String id) {
        deleter.delete(id);
    }

    @GetMapping
    @ApiOperation(value = "Service to list all people")
    public List<PersonV1DTO> list() {
        Type listType = new TypeToken<List<PersonV1DTO>>(){}.getType();
        return mapper.map(loader.list(), listType);
    }
}

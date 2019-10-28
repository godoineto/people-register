package com.people.register.api.address.v2;

import com.people.register.api.address.v2.dto.AddressV2DTO;
import io.swagger.annotations.Api;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v2/person/{personId}/address")
@Api("Address")
public class AddressV2Controller {

    @GetMapping
    public List<AddressV2DTO> list(@PathParam("personId") String personId) {
        List<AddressV2DTO> addresses = new ArrayList<>();
        val address = new AddressV2DTO();
        address.setCity("Palhoça");
        address.setNeighborhood("Pedra Branca");
        address.setCountry("Brasil");
        address.setNumber(347);
        address.setStreet("Rua da Pedra");
        address.setZipCode("88137-072");
        address.setState("SC");
        addresses.add(address);
        return addresses;
    }
}
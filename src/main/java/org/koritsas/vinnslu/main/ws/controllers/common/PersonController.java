package org.koritsas.vinnslu.main.ws.controllers.common;

import org.koritsas.vinnslu.main.models.common.Person;
import org.koritsas.vinnslu.main.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.main.ws.dto.common.PersonDto;
import org.koritsas.vinnslu.main.ws.services.crud.common.PersonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/person")
public class PersonController extends AbstractCRUDController<PersonService, Person, Long, PersonDto> {

    public PersonController(PersonService service) {
        super(service);
    }
}

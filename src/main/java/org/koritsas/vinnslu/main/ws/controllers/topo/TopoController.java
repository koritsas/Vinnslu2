package org.koritsas.vinnslu.main.ws.controllers.topo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.utils.TopoDeserializer;
import org.koritsas.vinnslu.main.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.main.ws.dto.topo.TopoDTO;
import org.koritsas.vinnslu.main.ws.services.crud.topo.TopoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topos")
@JsonDeserialize(using = TopoDeserializer.class)
public class TopoController extends AbstractCRUDController<TopoService, Topo, Long, TopoDTO> {
    public TopoController(TopoService service) {
	super(service);
    }

}

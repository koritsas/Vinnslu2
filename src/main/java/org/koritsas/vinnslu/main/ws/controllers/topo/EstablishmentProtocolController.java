package org.koritsas.vinnslu.main.ws.controllers.topo;

import org.koritsas.vinnslu.main.models.topo.EstablishmentProtocol;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.main.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.main.ws.dto.topo.EstablishmentProtocolDto;
import org.koritsas.vinnslu.main.ws.services.crud.topo.EstablishmentProtocolService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/data/establisment_protocol")
public class EstablishmentProtocolController extends AbstractCRUDController<EstablishmentProtocolService, EstablishmentProtocol,Long, EstablishmentProtocolDto> {
    public EstablishmentProtocolController(EstablishmentProtocolService service, GeometryModelMapper mapper) {
        super(service, mapper);
    }
}

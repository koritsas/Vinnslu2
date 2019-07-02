package org.koritsas.vinnslu.main.ws.controllers.topo;


import org.koritsas.vinnslu.main.models.topo.StandardEnvironmentalCommitments;
import org.koritsas.vinnslu.main.models.topo.StandardTechnicalCommitments;
import org.koritsas.vinnslu.main.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.main.ws.dto.topo.StandardEnvironmentalCommitmentsDTO;
import org.koritsas.vinnslu.main.ws.dto.topo.StandardTechnicalCommitmentsDTO;
import org.koritsas.vinnslu.main.ws.services.crud.topo.StandardEnvironmentalCommitmentsService;
import org.koritsas.vinnslu.main.ws.services.crud.topo.StandardTechnicalCommitmentsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/standardTechnicalCommitmens")
public class StandardTechnicalCommitmentsController extends AbstractCRUDController<StandardTechnicalCommitmentsService, StandardTechnicalCommitments, Long, StandardTechnicalCommitmentsDTO> {
    public StandardTechnicalCommitmentsController(StandardTechnicalCommitmentsService service) {
        super(service);
    }
}

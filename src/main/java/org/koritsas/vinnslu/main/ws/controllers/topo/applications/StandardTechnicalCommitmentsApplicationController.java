package org.koritsas.vinnslu.main.ws.controllers.topo.applications;

import org.koritsas.vinnslu.main.models.topo.applications.StandardTechnicalCommitmentsApplication;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.main.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.main.ws.dto.topo.applications.StandardEnvironmentalCommitmentsApplicationDto;
import org.koritsas.vinnslu.main.ws.services.applications.StandardTechnicalCommitmentsApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/applications/standardTechnicalCommitments")
public class StandardTechnicalCommitmentsApplicationController extends AbstractCRUDController<StandardTechnicalCommitmentsApplicationService, StandardTechnicalCommitmentsApplication, Long, StandardEnvironmentalCommitmentsApplicationDto> {

    public StandardTechnicalCommitmentsApplicationController(StandardTechnicalCommitmentsApplicationService service, GeometryModelMapper mapper) {
        super(service, mapper);
    }
}

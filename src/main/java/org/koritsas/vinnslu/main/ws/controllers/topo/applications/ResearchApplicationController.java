package org.koritsas.vinnslu.main.ws.controllers.topo.applications;

import org.koritsas.vinnslu.main.models.topo.applications.ResearchApplication;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.main.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.main.ws.dto.topo.applications.ResearchApplicationDto;
import org.koritsas.vinnslu.main.ws.services.applications.ResearchApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vinnslu/applications/research-license")
public class ResearchApplicationController extends AbstractCRUDController<ResearchApplicationService, ResearchApplication, Long, ResearchApplicationDto> {

    public ResearchApplicationController(ResearchApplicationService service, GeometryModelMapper mapper) {
        super(service, mapper);
    }
}

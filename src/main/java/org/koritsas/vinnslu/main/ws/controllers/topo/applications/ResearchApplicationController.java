package org.koritsas.vinnslu.main.ws.controllers.topo.applications;

import org.koritsas.vinnslu.main.models.topo.applications.ResearchApplication;
import org.koritsas.vinnslu.main.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.main.ws.dto.topo.applications.ResearchApplicationDto;
import org.koritsas.vinnslu.main.ws.services.applications.ResearchApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/applications/researchLicense")
public class ResearchApplicationController extends AbstractCRUDController<ResearchApplicationService, ResearchApplication, Long, ResearchApplicationDto> {
    public ResearchApplicationController(ResearchApplicationService service) {
        super(service);
    }
}

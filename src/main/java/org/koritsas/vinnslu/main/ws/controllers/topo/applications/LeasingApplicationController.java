package org.koritsas.vinnslu.main.ws.controllers.topo.applications;

import org.koritsas.vinnslu.main.models.topo.applications.LeasingApplication;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.main.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.main.ws.dto.topo.applications.LeasingApplicationDto;
import org.koritsas.vinnslu.main.ws.services.applications.LeasingApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/applications/leasing_application")
public class LeasingApplicationController extends AbstractCRUDController<LeasingApplicationService,LeasingApplication,Long, LeasingApplicationDto> {
    public LeasingApplicationController(LeasingApplicationService service, GeometryModelMapper mapper) {
        super(service, mapper);
    }
}

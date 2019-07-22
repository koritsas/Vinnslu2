package org.koritsas.vinnslu.main.ws.controllers.topo;

import org.koritsas.vinnslu.main.models.topo.LeasingResolution;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.main.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.main.ws.dto.topo.LeasingResolutionDto;
import org.koritsas.vinnslu.main.ws.services.crud.topo.LeasingResolutionService;
import org.springframework.stereotype.Controller;

@Controller("/leasing_resolution")
public class LeasingResolutionController extends AbstractCRUDController<LeasingResolutionService, LeasingResolution,Long, LeasingResolutionDto> {
    public LeasingResolutionController(LeasingResolutionService service, GeometryModelMapper mapper) {
        super(service, mapper);
    }
}

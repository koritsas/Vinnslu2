package org.koritsas.vinnslu.main.ws.controllers.topo;

import org.koritsas.vinnslu.main.models.topo.TechnicalStudy;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.main.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.main.ws.dto.topo.TechnicalStudyDTO;
import org.koritsas.vinnslu.main.ws.services.crud.topo.TechnicalStudyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data/technical_studies")
public class TechnicalStudiesController extends AbstractCRUDController<TechnicalStudyService, TechnicalStudy, Long, TechnicalStudyDTO> {

    public TechnicalStudiesController(TechnicalStudyService service, GeometryModelMapper mapper) {
        super(service, mapper);
    }
}

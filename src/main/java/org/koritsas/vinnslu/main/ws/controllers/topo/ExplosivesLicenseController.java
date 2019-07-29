package org.koritsas.vinnslu.main.ws.controllers.topo;

import org.koritsas.vinnslu.main.models.topo.ExplosivesLicense;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.main.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.main.ws.dto.topo.EXplosivesLicenseDTO;
import org.koritsas.vinnslu.main.ws.services.crud.topo.ExplosivesLicenseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data/explosives")
public class ExplosivesLicenseController extends AbstractCRUDController<ExplosivesLicenseService, ExplosivesLicense, Long, EXplosivesLicenseDTO> {

    public ExplosivesLicenseController(ExplosivesLicenseService service, GeometryModelMapper mapper) {
        super(service, mapper);
    }
}

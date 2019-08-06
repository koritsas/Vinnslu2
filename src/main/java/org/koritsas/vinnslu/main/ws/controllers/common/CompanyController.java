package org.koritsas.vinnslu.main.ws.controllers.common;

import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.main.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.main.ws.dto.common.CompanyDto;
import org.koritsas.vinnslu.main.ws.services.crud.common.CompanyService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping("/common/companies")
public class CompanyController extends AbstractCRUDController<CompanyService, Company, Long, CompanyDto> {

    public CompanyController(CompanyService service, GeometryModelMapper mapper) {
        super(service, mapper);
    }
}

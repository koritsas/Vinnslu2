package org.koritsas.vinnslu.main.ws.services.crud.common;

import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.ws.repos.common.CompanyRepository;
import org.koritsas.vinnslu.main.ws.services.crud.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends AbstractCRUDService<CompanyRepository, Company, Long> {

    public CompanyService(CompanyRepository repo) {
        super(repo);
    }
}

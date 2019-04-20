package org.koritsas.vinnslu.main.ws.services.crud.topo;

import org.koritsas.vinnslu.main.models.topo.ResearchLicense;
import org.koritsas.vinnslu.main.ws.repos.topo.ResearchLicenseRepository;
import org.koritsas.vinnslu.main.ws.services.crud.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class ResearchLicenseService extends AbstractCRUDService<ResearchLicenseRepository, ResearchLicense, Long> {
    public ResearchLicenseService(ResearchLicenseRepository repo) {
        super(repo);
    }
}

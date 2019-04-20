package org.koritsas.vinnslu.main.ws.services.crud.topo;

import org.koritsas.vinnslu.main.models.topo.ExplosivesLicense;
import org.koritsas.vinnslu.main.ws.repos.topo.ExplosivesLicenseRepository;
import org.koritsas.vinnslu.main.ws.services.crud.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class ExplosivesLicenseService extends AbstractCRUDService<ExplosivesLicenseRepository, ExplosivesLicense, Long> {
    public ExplosivesLicenseService(ExplosivesLicenseRepository repo) {
        super(repo);
    }
}

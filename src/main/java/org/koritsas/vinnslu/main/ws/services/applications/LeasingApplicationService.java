package org.koritsas.vinnslu.main.ws.services.applications;

import org.koritsas.vinnslu.main.models.topo.applications.LeasingApplication;
import org.koritsas.vinnslu.main.ws.repos.applications.LeasingApplicationRepository;
import org.koritsas.vinnslu.main.ws.services.crud.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class LeasingApplicationService extends AbstractCRUDService<LeasingApplicationRepository, LeasingApplication,Long> {
    public LeasingApplicationService(LeasingApplicationRepository repo) {
        super(repo);
    }
}

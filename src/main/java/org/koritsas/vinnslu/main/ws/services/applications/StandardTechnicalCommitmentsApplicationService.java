package org.koritsas.vinnslu.main.ws.services.applications;

import org.koritsas.vinnslu.main.models.topo.applications.StandardEnvironmentalCommitmentsApplication;
import org.koritsas.vinnslu.main.ws.repos.applications.StandardEnvironmentalCommitmentsApplicationRepository;
import org.koritsas.vinnslu.main.ws.services.crud.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class StandardTechnicalCommitmentsApplicationService extends AbstractCRUDService<StandardEnvironmentalCommitmentsApplicationRepository, StandardEnvironmentalCommitmentsApplication, Long> {
    public StandardTechnicalCommitmentsApplicationService(StandardEnvironmentalCommitmentsApplicationRepository repo) {
        super(repo);
    }
}

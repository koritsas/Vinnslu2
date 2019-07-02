package org.koritsas.vinnslu.main.ws.services.applications;

import org.koritsas.vinnslu.main.models.topo.applications.StandardEnvironmentalCommitmentsApplication;
import org.koritsas.vinnslu.main.models.topo.applications.StandardTechnicalCommitmentsApplication;
import org.koritsas.vinnslu.main.ws.repos.applications.StandardEnvironmentalCommitmentsApplicationRepository;
import org.koritsas.vinnslu.main.ws.repos.applications.StandardTechnicalCommitmentsApplicationRepository;
import org.koritsas.vinnslu.main.ws.services.crud.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class StandardTechnicalCommitmentsApplicationService extends AbstractCRUDService<StandardTechnicalCommitmentsApplicationRepository, StandardTechnicalCommitmentsApplication, Long> {
    public StandardTechnicalCommitmentsApplicationService(StandardTechnicalCommitmentsApplicationRepository repo) {
        super(repo);
    }
}

package org.koritsas.vinnslu.main.ws.services.applications;

import org.koritsas.vinnslu.main.models.topo.applications.ResearchApplication;
import org.koritsas.vinnslu.main.ws.repos.applications.ResearchApplicationRepository;
import org.koritsas.vinnslu.main.ws.services.crud.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class ResearchApplicationService extends AbstractCRUDService<ResearchApplicationRepository, ResearchApplication, Long> {
    public ResearchApplicationService(ResearchApplicationRepository repo) {
        super(repo);
    }
}

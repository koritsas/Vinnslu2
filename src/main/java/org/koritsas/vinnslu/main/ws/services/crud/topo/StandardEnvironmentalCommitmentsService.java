package org.koritsas.vinnslu.main.ws.services.crud.topo;

import org.koritsas.vinnslu.main.models.topo.StandardTechnicalCommitments;
import org.koritsas.vinnslu.main.ws.repos.topo.StandardEnvironmentalCommitmentsRepository;
import org.koritsas.vinnslu.main.ws.services.crud.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class StandardEnvironmentalCommitmentsService extends AbstractCRUDService<StandardEnvironmentalCommitmentsRepository, StandardTechnicalCommitments, Long> {
    public StandardEnvironmentalCommitmentsService(StandardEnvironmentalCommitmentsRepository repo) {
        super(repo);
    }
}

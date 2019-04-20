package org.koritsas.vinnslu.main.ws.services.crud.topo;

import org.koritsas.vinnslu.main.models.topo.StandardTechnicalCommitments;
import org.koritsas.vinnslu.main.ws.repos.topo.StandardTechnicalCommitmentsRepository;
import org.koritsas.vinnslu.main.ws.services.crud.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class StandardTechnicalCommitmentsService extends AbstractCRUDService<StandardTechnicalCommitmentsRepository, StandardTechnicalCommitments, Long> {
    public StandardTechnicalCommitmentsService(StandardTechnicalCommitmentsRepository repo) {
        super(repo);
    }
}

package org.koritsas.vinnslu.main.ws.services.crud.topo;

import org.koritsas.vinnslu.main.models.topo.LeasingResolution;
import org.koritsas.vinnslu.main.ws.repos.topo.LeasingResolutionRepository;
import org.koritsas.vinnslu.main.ws.services.crud.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class LeasingResolutionService extends AbstractCRUDService<LeasingResolutionRepository, LeasingResolution,Long> {
    public LeasingResolutionService(LeasingResolutionRepository repo) {
        super(repo);
    }
}

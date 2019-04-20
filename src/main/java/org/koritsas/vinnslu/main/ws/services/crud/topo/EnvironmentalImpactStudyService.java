package org.koritsas.vinnslu.main.ws.services.crud.topo;

import org.koritsas.vinnslu.main.models.topo.EnvironmentalImpactStudy;
import org.koritsas.vinnslu.main.ws.repos.topo.EnvironmentalImpactStudyRepository;
import org.koritsas.vinnslu.main.ws.services.crud.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class EnvironmentalImpactStudyService extends AbstractCRUDService<EnvironmentalImpactStudyRepository, EnvironmentalImpactStudy, Long> {
    public EnvironmentalImpactStudyService(EnvironmentalImpactStudyRepository repo) {
        super(repo);
    }
}

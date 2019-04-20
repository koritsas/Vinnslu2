package org.koritsas.vinnslu.main.ws.services.crud.topo;

import org.koritsas.vinnslu.main.models.topo.TechnicalStudy;
import org.koritsas.vinnslu.main.ws.repos.topo.TechnicalStudyRepository;
import org.koritsas.vinnslu.main.ws.services.crud.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class TechnicalStudyService extends AbstractCRUDService<TechnicalStudyRepository, TechnicalStudy, Long> {
    public TechnicalStudyService(TechnicalStudyRepository repo) {
        super(repo);
    }
}

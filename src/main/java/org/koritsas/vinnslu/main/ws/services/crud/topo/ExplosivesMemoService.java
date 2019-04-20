package org.koritsas.vinnslu.main.ws.services.crud.topo;

import org.koritsas.vinnslu.main.models.topo.ExplosivesMemo;
import org.koritsas.vinnslu.main.ws.repos.topo.ExplosivesMemoRepository;
import org.koritsas.vinnslu.main.ws.services.crud.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class ExplosivesMemoService extends AbstractCRUDService<ExplosivesMemoRepository, ExplosivesMemo, Long> {
    public ExplosivesMemoService(ExplosivesMemoRepository repo) {
        super(repo);
    }
}

package org.koritsas.vinnslu.main.ws.services.crud.common;

import org.koritsas.vinnslu.main.models.common.Opinion;
import org.koritsas.vinnslu.main.ws.repos.common.OpinionRepository;
import org.koritsas.vinnslu.main.ws.services.crud.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class OpinionService extends AbstractCRUDService<OpinionRepository, Opinion, Long> {
    public OpinionService(OpinionRepository repo) {
        super(repo);
    }
}

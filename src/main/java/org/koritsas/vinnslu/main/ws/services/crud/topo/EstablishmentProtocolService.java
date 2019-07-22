package org.koritsas.vinnslu.main.ws.services.crud.topo;

import org.koritsas.vinnslu.main.models.topo.EstablishmentProtocol;
import org.koritsas.vinnslu.main.ws.repos.topo.EstablishmentProtocolRepository;
import org.koritsas.vinnslu.main.ws.services.crud.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class EstablishmentProtocolService extends AbstractCRUDService<EstablishmentProtocolRepository, EstablishmentProtocol,Long> {
    public EstablishmentProtocolService(EstablishmentProtocolRepository repo) {
        super(repo);
    }
}

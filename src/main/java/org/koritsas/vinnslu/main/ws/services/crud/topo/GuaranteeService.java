package org.koritsas.vinnslu.main.ws.services.crud.topo;

import org.koritsas.vinnslu.main.models.topo.Guarantee;
import org.koritsas.vinnslu.main.ws.repos.topo.GuaranteeRepository;
import org.koritsas.vinnslu.main.ws.services.crud.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class GuaranteeService extends AbstractCRUDService<GuaranteeRepository, Guarantee, Long> {
    public GuaranteeService(GuaranteeRepository repo) {
        super(repo);
    }
}

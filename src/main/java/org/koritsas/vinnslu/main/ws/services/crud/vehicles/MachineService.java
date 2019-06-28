package org.koritsas.vinnslu.main.ws.services.crud.vehicles;

import org.koritsas.vinnslu.main.models.vehicles.Machine;
import org.koritsas.vinnslu.main.ws.repos.vehicles.MachineRepository;
import org.koritsas.vinnslu.main.ws.services.crud.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class MachineService extends AbstractCRUDService<MachineRepository, Machine, Long> {
    public MachineService(MachineRepository repo) {
        super(repo);
    }
}

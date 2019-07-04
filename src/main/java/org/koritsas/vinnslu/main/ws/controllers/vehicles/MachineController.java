package org.koritsas.vinnslu.main.ws.controllers.vehicles;

import org.koritsas.vinnslu.main.models.vehicles.Machine;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.main.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.main.ws.dto.vehicles.MachineDTO;
import org.koritsas.vinnslu.main.ws.services.crud.vehicles.MachineService;

public class MachineController extends AbstractCRUDController<MachineService, Machine, Long, MachineDTO> {


    public MachineController(MachineService service, GeometryModelMapper mapper) {
        super(service, mapper);
    }
}

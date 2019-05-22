package org.koritsas.vinnslu.main.ws.controllers.workflow;


import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.main.ws.dto.topo.TopoDTO;
import org.koritsas.vinnslu.main.ws.services.workflow.ResearchApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/workflow")
public class ResearchApplicationController {

    private ResearchApplicationService researchApplicationService;

    private GeometryModelMapper mapper;

    @Autowired
    public ResearchApplicationController(ResearchApplicationService researchApplicationService, GeometryModelMapper mapper){
        this.researchApplicationService=researchApplicationService;
        this.mapper=mapper;
    }

    @PostMapping("/topo")
    public ResponseEntity<String> startProcess(@RequestBody TopoDTO dto){

        this.researchApplicationService.startProcess(mapper.map(dto, Topo.class));

        return ResponseEntity.ok("Started application process for Topo " + dto.toString());

    }
}

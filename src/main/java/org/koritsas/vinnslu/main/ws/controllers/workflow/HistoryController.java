package org.koritsas.vinnslu.main.ws.controllers.workflow;

import org.flowable.engine.history.HistoricProcessInstance;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.main.ws.dto.topo.TopoDTO;
import org.koritsas.vinnslu.main.ws.services.workflow.HistoricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vinnslu/history")
public class HistoryController {

    private HistoricService historicService;

    private GeometryModelMapper mapper;

    @Autowired
    public HistoryController(HistoricService historicService, GeometryModelMapper mapper){
        this.historicService=historicService;
        this.mapper=mapper;
    }


    @GetMapping("/process/{processId}")
    public ResponseEntity<String> getHistoricProcessInstanceInstance(@PathVariable String processId){

        HistoricProcessInstance processInstance = historicService.getHistoricProcessInstanceById(processId);


        return ResponseEntity.ok(processInstance.getId());
    }

    @PostMapping("/process")
    public ResponseEntity<String> getHistoricProcessInstanceByTopo(@RequestBody TopoDTO dto){

        HistoricProcessInstance processInstance = historicService.getHistoriceProcessInstanceByTopo(mapper.map(dto, Topo.class));

        return ResponseEntity.ok(processInstance.getId());
    }
}

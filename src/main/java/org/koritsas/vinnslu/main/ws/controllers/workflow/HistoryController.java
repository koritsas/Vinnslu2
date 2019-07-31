package org.koritsas.vinnslu.main.ws.controllers.workflow;

import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.main.utils.TaskRepresentation;
import org.koritsas.vinnslu.main.ws.dto.topo.TopoDTO;
import org.koritsas.vinnslu.main.ws.services.workflow.HistoricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vinnslu/workflow/process/history")
public class HistoryController {

    private HistoricService historicService;


    private GeometryModelMapper mapper;

    @Autowired
    public HistoryController(HistoricService historicService, GeometryModelMapper mapper){
        this.historicService=historicService;
        this.mapper=mapper;
    }


    @GetMapping("/{processId}")
    public ResponseEntity<String> getHistoricProcessInstanceInstance(@PathVariable String processId){

        HistoricProcessInstance processInstance = historicService.getHistoricProcessInstanceById(processId);


        return ResponseEntity.ok(processInstance.getId());
    }

    @PostMapping("/topo")
    public ResponseEntity<String> getHistoricProcessInstanceByTopo(@RequestBody TopoDTO dto){

        HistoricProcessInstance processInstance = historicService.getHistoriceProcessInstanceByTopo(mapper.map(dto, Topo.class));

        return ResponseEntity.ok(processInstance.getId());
    }

    @GetMapping("/{processId}/tasks")
    public ResponseEntity<Map<String,List<HistoricTaskInstance>>> getHistoricTasksFromProcessWithId(@PathVariable String processId){

        List<TaskRepresentation> taskRepresentations = new ArrayList<>();

        Map<String,List<HistoricTaskInstance>> taskInstances =this.historicService.getAllTasksFromProcess(processId);

       // taskInstances.stream().forEach(historicTaskInstance -> taskRepresentations.add(new TaskRepresentation(historicTaskInstance)));

        return ResponseEntity.ok(taskInstances);

    }
}

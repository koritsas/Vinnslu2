package org.koritsas.vinnslu.main.ws.controllers.workflow;

import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.main.utils.ProcessInstanceRepresentation;
import org.koritsas.vinnslu.main.utils.TaskRepresentation;
import org.koritsas.vinnslu.main.ws.dto.topo.TopoDTO;
import org.koritsas.vinnslu.main.ws.services.workflow.HistoricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * @param processId
     * @return returns a historic process instance representation
     */

    @GetMapping("/{processId}")
    public ResponseEntity<ProcessInstanceRepresentation> getHistoricProcessInstanceInstance(@PathVariable String processId) {

        HistoricProcessInstance processInstance = historicService.getHistoricProcessInstanceById(processId);


        return ResponseEntity.ok(new ProcessInstanceRepresentation(processInstance));
    }

    /**
     *
     * @param dto
     * @return A historic process instance representation by posting a topo
     */

    @PostMapping("/topo")
    public ResponseEntity<ProcessInstanceRepresentation> getHistoricProcessInstanceByTopo(@RequestBody TopoDTO dto) {

        HistoricProcessInstance processInstance = historicService.getHistoriceProcessInstanceByTopo(mapper.map(dto, Topo.class));

        return ResponseEntity.ok(new ProcessInstanceRepresentation(processInstance));
    }

    /**
     *
     * @param processId
     * @return All finished task of a process with process id
     */

    @GetMapping("/{processId}/tasks")
    public ResponseEntity<List<TaskRepresentation>> getHistoricTasksFromProcessWithId(@PathVariable String processId) {


        List<HistoricTaskInstance> tasks = this.historicService.getAllFinishedTasksFromProcess(processId);
        // taskInstances.stream().forEach(historicTaskInstance -> taskRepresentations.add(new TaskRepresentation(historicTaskInstance)));

        List<TaskRepresentation> taskRepresentations = new ArrayList<>();

        tasks.stream().forEach(task -> taskRepresentations.add(new TaskRepresentation(task)));


        return ResponseEntity.ok(taskRepresentations);

    }

    /**
     * @param dto
     * @return All finished tasks of a process with process variable topo
     */

    @PostMapping("/tasks")
    public List<TaskRepresentation> getHistoricTasksByTopo(@RequestBody TopoDTO dto) {

        List<HistoricTaskInstance> tasks = historicService.getHistoricTasksWithTopo(mapper.map(dto, Topo.class));

        List<TaskRepresentation> taskRepresentations = new ArrayList<>();

        tasks.stream().forEach(task -> taskRepresentations.add(new TaskRepresentation(task)));

        return taskRepresentations;

    }

    @GetMapping("/tasks/topo/{id}")
    public ResponseEntity<List<TaskRepresentation>> getHistoricTaskByTopoId(@PathVariable Long id) {

        List<HistoricTaskInstance> historicTaskInstances = this.historicService.getHistoricTaskFromProcessWithTopoId(id);

        List<TaskRepresentation> taskRepresentations = new ArrayList<>();

        historicTaskInstances.forEach(historicTask -> taskRepresentations.add(new TaskRepresentation(historicTask)));

        return ResponseEntity.ok(taskRepresentations);

    }
}

package org.koritsas.vinnslu.main.ws.controllers.workflow;

import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.koritsas.vinnslu.main.models.common.Opinion;
import org.koritsas.vinnslu.main.models.topo.applications.ResearchApplication;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.main.utils.TaskRepresentation;
import org.koritsas.vinnslu.main.ws.dto.common.OpinionDTO;
import org.koritsas.vinnslu.main.ws.dto.topo.applications.ResearchApplicationDto;
import org.koritsas.vinnslu.main.ws.services.workflow.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/workflow")
public class ProcessController {

    private GeometryModelMapper mapper;

    private ProcessService processService;

    @Autowired
    public ProcessController(ProcessService processService, GeometryModelMapper mapper) {
        this.processService = processService;
        this.mapper = mapper;
    }

    @PostMapping("/process")
    public ResponseEntity<String> startProcess(@RequestBody ResearchApplicationDto dto){

        processService.startProcessWithResearchApplication(mapper.map(dto,ResearchApplication.class));

        return ResponseEntity.status(201).body("Started new process instance");
    }


    @GetMapping("/process/tasks")
    public List<TaskRepresentation> getAllTasks(@RequestParam(required = false) String processId,@RequestParam(required = false) String taskId){

       List<Task> tasks = processService.getAllTasks(processId,taskId);

       List<TaskRepresentation> taskRepresentations = new ArrayList<>();

       tasks.forEach(task -> {
           TaskRepresentation taskRepresentation = new TaskRepresentation();
           taskRepresentation.setId(task.getId());
           taskRepresentation.setCreateTime(task.getCreateTime());
           taskRepresentation.setCategory(task.getCategory());
           taskRepresentation.setName(task.getName());
           taskRepresentation.setProcessInstanceId(task.getProcessInstanceId());
           taskRepresentation.setScopeId(task.getScopeId());
           taskRepresentation.setProcessVariables(task.getProcessVariables());

           taskRepresentations.add(taskRepresentation);
       });

       return taskRepresentations;
    }

    @PostMapping("/process/tasks/{taskId}")
    public ResponseEntity<String> completeTask(@PathVariable String taskId,@RequestBody Opinion dto){

        processService.completeTask(taskId,mapper.map(dto,Opinion.class));

        return ResponseEntity.ok("asfdasfdsafa");
    }

}



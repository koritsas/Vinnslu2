package org.koritsas.vinnslu.main.ws.controllers.workflow;

import org.flowable.task.api.Task;
import org.koritsas.vinnslu.main.models.topo.applications.ResearchApplication;
import org.koritsas.vinnslu.main.models.topo.applications.StandardEnvironmentalCommitmentsApplication;
import org.koritsas.vinnslu.main.models.topo.applications.StandardTechnicalCommitmentsApplication;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.main.utils.TaskRepresentation;
import org.koritsas.vinnslu.main.ws.dto.topo.StandardTechnicalCommitmentsDTO;
import org.koritsas.vinnslu.main.ws.dto.topo.applications.ResearchApplicationDto;
import org.koritsas.vinnslu.main.ws.dto.topo.applications.StandardEnvironmentalCommitmentsApplicationDto;
import org.koritsas.vinnslu.main.ws.dto.topo.applications.StandardTechnicalCommitmentsApplicationDto;
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

    //Completes Research Application Opinions Task

    @PutMapping("/process/tasks/research/application/{taskId}")
    public ResponseEntity<String> completeResearchApplicationOpinionsTask(@PathVariable String taskId, @RequestBody ResearchApplicationDto dto){

        processService.completeResearchApplicationOpinionsTask(taskId,mapper.map(dto,ResearchApplication.class));

        return ResponseEntity.ok("Research application opinions stage completed");
    }


    //Completes Standard Environmental Commitments Application Task by POSTing
    @PostMapping("process/tasks/standardEnvironmentalCommitments/application/{taskId}")
    public ResponseEntity<String> completeStandardEnvironmentalCommitmentsTask(@PathVariable String taskId, @RequestBody StandardEnvironmentalCommitmentsApplicationDto dto){

        StandardEnvironmentalCommitmentsApplication stcApplication = mapper.map(dto,StandardEnvironmentalCommitmentsApplication.class);

        processService.completeStandardEnvironmentalCommitmentsApplicationTask(taskId,stcApplication);

        return ResponseEntity.ok("Standard environmental commitments task completed by posting " + stcApplication.toString());
    }

    //Completes Standard Environmental Commitments Opinions Task by PUTing
    @PutMapping("process/tasks/standardEnvironmentalCommitments/application/opinions/{taskId}")
    public ResponseEntity<String> completeStandardEnvironmentalCommitmentsOpinionsTask(@PathVariable String taskId,@RequestBody StandardEnvironmentalCommitmentsApplicationDto dto){

        StandardEnvironmentalCommitmentsApplication secApplication = mapper.map(dto,StandardEnvironmentalCommitmentsApplication.class);

        System.out.println(secApplication.toString());

        processService.completeStandardEnvironmentalCommitmentsOpinionsTask(taskId,secApplication);

        return ResponseEntity.ok("Completed Standard Environmental Commitmens Opinions task by updating to "+ secApplication.toString());
    }


    @PostMapping("/process/tasks/standardTechnicalCommitments/application/{taskId}")
    public ResponseEntity<String> completeStandardTechnicalCommitmentsApplicationTask(@PathVariable String taskId, @RequestBody StandardTechnicalCommitmentsApplicationDto dto){


        StandardTechnicalCommitmentsApplication stcApplication = mapper.map(dto,StandardTechnicalCommitmentsApplication.class);

        processService.completeStandardTechnicalCommitmentsApplicationTask(taskId,stcApplication);

        return ResponseEntity.ok("Completed Standard Technical Commitments Application task by posting " + stcApplication.toString());
    }

    @PutMapping("/process/tasks/standardTechnicalCommitments/application/opinions/{taskId}")
    public ResponseEntity<String> completeStandardTechnicalCommitmentsOpinionsTask(@PathVariable String taskId,@RequestBody StandardTechnicalCommitmentsApplicationDto dto){

        StandardTechnicalCommitmentsApplication stcApplication = mapper.map(dto,StandardTechnicalCommitmentsApplication.class);
        processService.completeStandardTechnicalCommitmentsOpinionsTask(taskId,stcApplication);

        return ResponseEntity.ok("Completed Standard Technical Commitments Opinions task by updating to " + stcApplication);

    }
}



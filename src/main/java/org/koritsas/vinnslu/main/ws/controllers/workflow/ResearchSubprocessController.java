package org.koritsas.vinnslu.main.ws.controllers.workflow;

import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.koritsas.vinnslu.main.models.topo.ResearchLicense;
import org.koritsas.vinnslu.main.models.topo.StandardEnvironmentalCommitments;
import org.koritsas.vinnslu.main.models.topo.StandardTechnicalCommitments;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.models.topo.applications.ResearchApplication;
import org.koritsas.vinnslu.main.models.topo.applications.StandardEnvironmentalCommitmentsApplication;
import org.koritsas.vinnslu.main.models.topo.applications.StandardTechnicalCommitmentsApplication;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.main.utils.ProcessInstanceRepresentation;
import org.koritsas.vinnslu.main.utils.TaskRepresentation;
import org.koritsas.vinnslu.main.ws.dto.topo.ResearchLicenseDTO;
import org.koritsas.vinnslu.main.ws.dto.topo.StandardEnvironmentalCommitmentsDTO;
import org.koritsas.vinnslu.main.ws.dto.topo.StandardTechnicalCommitmentsDTO;
import org.koritsas.vinnslu.main.ws.dto.topo.TopoDTO;
import org.koritsas.vinnslu.main.ws.dto.topo.applications.ResearchApplicationDto;
import org.koritsas.vinnslu.main.ws.dto.topo.applications.StandardEnvironmentalCommitmentsApplicationDto;
import org.koritsas.vinnslu.main.ws.dto.topo.applications.StandardTechnicalCommitmentsApplicationDto;
import org.koritsas.vinnslu.main.ws.services.workflow.ResearchSubprocessService;
import org.koritsas.vinnslu.main.ws.services.workflow.WorkflowProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vinnslu/workflow/research")
public class ResearchSubprocessController {

    private GeometryModelMapper mapper;

    private ResearchSubprocessService researchSubprocessService;

    private WorkflowProcessService workflowService;

    @Autowired
    public ResearchSubprocessController(ResearchSubprocessService researchSubprocessService,WorkflowProcessService workflowProcessService, GeometryModelMapper mapper) {
        this.researchSubprocessService = researchSubprocessService;
        this.workflowService = workflowProcessService;
        this.mapper = mapper;
    }

    @PostMapping("/process")
    public ResponseEntity<ProcessInstanceRepresentation> startProcess(@RequestBody ResearchApplicationDto dto){

        ProcessInstance processInstance = researchSubprocessService.startProcessWithResearchApplication(mapper.map(dto,ResearchApplication.class));

        ProcessInstanceRepresentation processInstanceRepresentation = new ProcessInstanceRepresentation(processInstance);
        return ResponseEntity.status(201).body(processInstanceRepresentation);
    }

    @PostMapping("/process/topo")
    public ResponseEntity<ProcessInstanceRepresentation> getProcessInstanceByTopo(@RequestBody TopoDTO dto){

        ProcessInstance processInstance = researchSubprocessService.getProcessInstanceByTopo(mapper.map(dto, Topo.class));

        ProcessInstanceRepresentation processInstanceRepresentation = new ProcessInstanceRepresentation(processInstance);

        return ResponseEntity.ok(processInstanceRepresentation);
    }


    @GetMapping("/process/tasks")
    public List<TaskRepresentation> getAllTasks(@RequestParam(required = false) String processId,@RequestParam(required = false) String taskId){

       List<Task> tasks = researchSubprocessService.getAllTasks(processId,taskId);

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

    @PutMapping("/research_application/opinions/{taskId}")
    public ResponseEntity<String> completeResearchApplicationOpinionsTask(@PathVariable String taskId, @RequestBody ResearchApplicationDto dto){

        researchSubprocessService.completeResearchApplicationOpinionsTask(taskId,mapper.map(dto,ResearchApplication.class));

        return ResponseEntity.ok("Research application opinions stage completed");
    }


    //Completes Standard Environmental Commitments Application Task by POSTing
    @PostMapping("/standard_environmental_commitments_application/{taskId}")
    public ResponseEntity<String> completeStandardEnvironmentalCommitmentsTask(@PathVariable String taskId, @RequestBody StandardEnvironmentalCommitmentsApplicationDto dto){

        StandardEnvironmentalCommitmentsApplication stcApplication = mapper.map(dto,StandardEnvironmentalCommitmentsApplication.class);

        researchSubprocessService.completeStandardEnvironmentalCommitmentsApplicationTask(taskId,stcApplication);

        return ResponseEntity.ok("Standard environmental commitments task completed by posting " + stcApplication.toString());
    }

    //Completes Standard Environmental Commitments Opinions Task by PUTing
    @PutMapping("process/tasks/standard_environmental_commitments_application/opinions/{taskId}")
    public ResponseEntity<String> completeStandardEnvironmentalCommitmentsOpinionsTask(@PathVariable String taskId,@RequestBody StandardEnvironmentalCommitmentsApplicationDto dto){

        StandardEnvironmentalCommitmentsApplication secApplication = mapper.map(dto,StandardEnvironmentalCommitmentsApplication.class);

        System.out.println(secApplication.toString());

        researchSubprocessService.completeStandardEnvironmentalCommitmentsOpinionsTask(taskId,secApplication);

        return ResponseEntity.ok("Completed Standard Environmental Commitmens Opinions task by updating to "+ secApplication.toString());
    }


    @PostMapping("/process/tasks/standard_technical_commitments/application/{taskId}")
    public ResponseEntity<String> completeStandardTechnicalCommitmentsApplicationTask(@PathVariable String taskId, @RequestBody StandardTechnicalCommitmentsApplicationDto dto){


        StandardTechnicalCommitmentsApplication stcApplication = mapper.map(dto,StandardTechnicalCommitmentsApplication.class);

        researchSubprocessService.completeStandardTechnicalCommitmentsApplicationTask(taskId,stcApplication);

        return ResponseEntity.ok("Completed Standard Technical Commitments Application task by posting " + stcApplication.toString());
    }

    @PutMapping("/standard_technical_commitments_application/opinions/{taskId}")
    public ResponseEntity<String> completeStandardTechnicalCommitmentsOpinionsTask(@PathVariable String taskId,@RequestBody StandardTechnicalCommitmentsApplicationDto dto){

        StandardTechnicalCommitmentsApplication stcApplication = mapper.map(dto,StandardTechnicalCommitmentsApplication.class);
        researchSubprocessService.completeStandardTechnicalCommitmentsOpinionsTask(taskId,stcApplication);

        return ResponseEntity.ok("Completed Standard Technical Commitments Opinions task by updating to " + stcApplication);

    }

    @PostMapping("/standard_technical_commitments/{taskId}")
    public ResponseEntity<String> completeStandardTechnicalCommitmentsTask(@PathVariable String taskId,@RequestBody StandardTechnicalCommitmentsDTO dto){

        StandardTechnicalCommitments standardTechnicalCommitments = mapper.map(dto,StandardTechnicalCommitments.class);

        researchSubprocessService.completeStandardTechnicalCommitmentsTask(taskId,standardTechnicalCommitments);

        return ResponseEntity.ok("Completed task with "+standardTechnicalCommitments.toString());

    }

    @PostMapping("/standard_environmental_commitments/{taskId}")
    public ResponseEntity<String> completedStandardEnvironmentalCommitmentsTask(@PathVariable String taskId, @RequestBody StandardEnvironmentalCommitmentsDTO dto){

        StandardEnvironmentalCommitments standardEnvironmentalCommitments = mapper.map(dto,StandardEnvironmentalCommitments.class);

        researchSubprocessService.completeStandardEnvironmentalCommitmentsTask(taskId,standardEnvironmentalCommitments);

        return ResponseEntity.ok("Completed task with "+standardEnvironmentalCommitments.toString());
    }

    @PostMapping("/reseasrch_license/{taskId}")
    public ResponseEntity<String> createResearchLicenseTask(@PathVariable String taskId, @RequestBody ResearchLicenseDTO dto){

        ResearchLicense researchLicense = mapper.map(dto,ResearchLicense.class);

        researchSubprocessService.createResearchLicense(taskId,researchLicense);

        return ResponseEntity.ok("Research License created " + researchLicense.toString());
    }

    @PostMapping("/process/tasks/reseasrch_license/proceed_to_leasing/{taskId}")
    public ResponseEntity<String> completeResearchLicenseTask(@PathVariable String taskId){

        researchSubprocessService.completeResearchLicenseTask(taskId);

        return ResponseEntity.ok("Research License ended. Proceed to leasing process?");
    }
}



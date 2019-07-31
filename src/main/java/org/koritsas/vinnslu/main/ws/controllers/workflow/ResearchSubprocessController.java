package org.koritsas.vinnslu.main.ws.controllers.workflow;

import org.flowable.engine.runtime.ProcessInstance;
import org.koritsas.vinnslu.main.models.topo.ResearchLicense;
import org.koritsas.vinnslu.main.models.topo.StandardEnvironmentalCommitments;
import org.koritsas.vinnslu.main.models.topo.StandardTechnicalCommitments;
import org.koritsas.vinnslu.main.models.topo.applications.ResearchApplication;
import org.koritsas.vinnslu.main.models.topo.applications.StandardEnvironmentalCommitmentsApplication;
import org.koritsas.vinnslu.main.models.topo.applications.StandardTechnicalCommitmentsApplication;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.main.utils.ProcessInstanceRepresentation;
import org.koritsas.vinnslu.main.ws.dto.topo.ResearchLicenseDTO;
import org.koritsas.vinnslu.main.ws.dto.topo.StandardEnvironmentalCommitmentsDTO;
import org.koritsas.vinnslu.main.ws.dto.topo.StandardTechnicalCommitmentsDTO;
import org.koritsas.vinnslu.main.ws.dto.topo.applications.ResearchApplicationDto;
import org.koritsas.vinnslu.main.ws.dto.topo.applications.StandardEnvironmentalCommitmentsApplicationDto;
import org.koritsas.vinnslu.main.ws.dto.topo.applications.StandardTechnicalCommitmentsApplicationDto;
import org.koritsas.vinnslu.main.ws.services.workflow.ResearchSubprocessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vinnslu/workflow/process")
public class ResearchSubprocessController {

    private GeometryModelMapper mapper;

    private ResearchSubprocessService researchSubprocessService;


    @Autowired
    public ResearchSubprocessController(ResearchSubprocessService researchSubprocessService, GeometryModelMapper mapper) {
        this.researchSubprocessService = researchSubprocessService;
        this.mapper = mapper;
    }

    @PostMapping("/research-application")
    public ResponseEntity<ProcessInstanceRepresentation> startProcess(@RequestBody ResearchApplicationDto dto) {

        ProcessInstance processInstance = researchSubprocessService.startProcessWithResearchApplication(mapper.map(dto,ResearchApplication.class));

        ProcessInstanceRepresentation processInstanceRepresentation = new ProcessInstanceRepresentation(processInstance);



        return ResponseEntity.ok(processInstanceRepresentation);
    }




    //Completes Research Application Opinions Task

    @PutMapping("/research-application/opinions/{taskId}")
    public ResponseEntity<String> completeResearchApplicationOpinionsTask(@PathVariable String taskId, @RequestBody ResearchApplicationDto dto){

        researchSubprocessService.completeResearchApplicationOpinionsTask(taskId,mapper.map(dto,ResearchApplication.class));

        return ResponseEntity.ok("Research application opinions stage completed");
    }


    //Completes Standard Environmental Commitments Application Task by POSTing
    @PostMapping("/standard-environmental-commitments-application/{taskId}")
    public ResponseEntity<String> completeStandardEnvironmentalCommitmentsTask(@PathVariable String taskId, @RequestBody StandardEnvironmentalCommitmentsApplicationDto dto){

        StandardEnvironmentalCommitmentsApplication stcApplication = mapper.map(dto,StandardEnvironmentalCommitmentsApplication.class);

        researchSubprocessService.completeStandardEnvironmentalCommitmentsApplicationTask(taskId,stcApplication);

        return ResponseEntity.ok("Standard environmental commitments task completed by posting " + stcApplication.toString());
    }

    //Completes Standard Environmental Commitments Opinions Task by PUTing
    @PutMapping("/standard-environmental-commitments-application/opinions/{taskId}")
    public ResponseEntity<String> completeStandardEnvironmentalCommitmentsOpinionsTask(@PathVariable String taskId,@RequestBody StandardEnvironmentalCommitmentsApplicationDto dto){

        StandardEnvironmentalCommitmentsApplication secApplication = mapper.map(dto,StandardEnvironmentalCommitmentsApplication.class);

        System.out.println(secApplication.toString());

        researchSubprocessService.completeStandardEnvironmentalCommitmentsOpinionsTask(taskId,secApplication);

        return ResponseEntity.ok("Completed Standard Environmental Commitmens Opinions task by updating to "+ secApplication.toString());
    }


    @PostMapping("/standard-technical-commitments-application/{taskId}")
    public ResponseEntity<String> completeStandardTechnicalCommitmentsApplicationTask(@PathVariable String taskId, @RequestBody StandardTechnicalCommitmentsApplicationDto dto){


        StandardTechnicalCommitmentsApplication stcApplication = mapper.map(dto,StandardTechnicalCommitmentsApplication.class);

        researchSubprocessService.completeStandardTechnicalCommitmentsApplicationTask(taskId,stcApplication);

        return ResponseEntity.ok("Completed Standard Technical Commitments Application task by posting " + stcApplication.toString());
    }

    @PutMapping("/standard-technical-commitments-application/opinions/{taskId}")
    public ResponseEntity<String> completeStandardTechnicalCommitmentsOpinionsTask(@PathVariable String taskId,@RequestBody StandardTechnicalCommitmentsApplicationDto dto){

        StandardTechnicalCommitmentsApplication stcApplication = mapper.map(dto,StandardTechnicalCommitmentsApplication.class);
        researchSubprocessService.completeStandardTechnicalCommitmentsOpinionsTask(taskId,stcApplication);

        return ResponseEntity.ok("Completed Standard Technical Commitments Opinions task by updating to " + stcApplication);

    }

    @PostMapping("/standard-technical-commitments/{taskId}")
    public ResponseEntity<String> completeStandardTechnicalCommitmentsTask(@PathVariable String taskId,@RequestBody StandardTechnicalCommitmentsDTO dto){

        StandardTechnicalCommitments standardTechnicalCommitments = mapper.map(dto,StandardTechnicalCommitments.class);

        researchSubprocessService.completeStandardTechnicalCommitmentsTask(taskId,standardTechnicalCommitments);

        return ResponseEntity.ok("Completed task with "+standardTechnicalCommitments.toString());

    }

    @PostMapping("/standard-environmental-commitments/{taskId}")
    public ResponseEntity<String> completedStandardEnvironmentalCommitmentsTask(@PathVariable String taskId, @RequestBody StandardEnvironmentalCommitmentsDTO dto){

        StandardEnvironmentalCommitments standardEnvironmentalCommitments = mapper.map(dto,StandardEnvironmentalCommitments.class);

        researchSubprocessService.completeStandardEnvironmentalCommitmentsTask(taskId,standardEnvironmentalCommitments);

        return ResponseEntity.ok("Completed task with "+standardEnvironmentalCommitments.toString());
    }

    @PostMapping("/reseasrch-license/{taskId}")
    public ResponseEntity<String> createResearchLicenseTask(@PathVariable String taskId, @RequestBody ResearchLicenseDTO dto){

        ResearchLicense researchLicense = mapper.map(dto,ResearchLicense.class);

        researchSubprocessService.createResearchLicense(taskId,researchLicense);

        return ResponseEntity.ok("Research License created " + researchLicense.toString());
    }

    @PostMapping("/reseasrch-license/proceed-to-leasing/{taskId}")
    public ResponseEntity<String> completeResearchLicenseTask(@PathVariable String taskId){

        researchSubprocessService.completeResearchLicenseTask(taskId);

        return ResponseEntity.ok("Research License ended. Proceed to leasing process?");
    }
}



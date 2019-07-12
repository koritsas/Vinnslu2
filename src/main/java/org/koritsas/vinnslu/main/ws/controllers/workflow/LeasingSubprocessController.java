package org.koritsas.vinnslu.main.ws.controllers.workflow;

import lombok.AllArgsConstructor;
import org.flowable.task.api.Task;
import org.koritsas.vinnslu.main.models.topo.*;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.main.ws.dto.topo.*;
import org.koritsas.vinnslu.main.ws.services.workflow.LeasingSubprocessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vinnslu/workflow/leasing")
public class LeasingSubprocessController {

    private LeasingSubprocessService leasingSubprocessService;

    private GeometryModelMapper mapper;

    @Autowired
    public LeasingSubprocessController(LeasingSubprocessService leasingSubprocessService,GeometryModelMapper mapper){
        this.mapper=mapper;
        this.leasingSubprocessService=leasingSubprocessService;
    }

    @PostMapping("/environmental_impact_study/{taskId}")
    public ResponseEntity<String> createEnvironmentalImpactStudyTask(@PathVariable String taskId, @RequestBody EnvironmentalImpactStudyDTO dto){

        leasingSubprocessService.createEnvironmentalImpactStudy(taskId,mapper.map(dto, EnvironmentalImpactStudy.class));

        return ResponseEntity.ok("Environmental Impact Study task with id "+ taskId +" completed.");
    }

    @PutMapping("/environmental_impact_study/{taskId}")
    public ResponseEntity<String> updateEnvironmentalImpactStudyTask(@PathVariable String taskId, @RequestBody EnvironmentalImpactStudyDTO dto){

        leasingSubprocessService.updateEnvironmentalImpactStudy(taskId,mapper.map(dto,EnvironmentalImpactStudy.class));

        return ResponseEntity.ok("Environmental Impact Study approved");
    }

    @PostMapping("/technical_study/{taskId}")
    public ResponseEntity<String> createTechnicalStudyTask(@PathVariable String taskId, @RequestBody TechnicalStudyDTO dto){

        leasingSubprocessService.createTechnicalStudy(taskId,mapper.map(dto, TechnicalStudy.class));

        return ResponseEntity.ok("Technical Study task with id "+ taskId +" completed.");
    }

    @PutMapping("/technical_study/{taskId}")
    public ResponseEntity<String> updateTechnicalStudyTask(@PathVariable String taskId, @RequestBody TechnicalStudyDTO dto){

        leasingSubprocessService.updateTechnicalStudy(taskId,mapper.map(dto,TechnicalStudy.class));

        return ResponseEntity.ok(" Technical Study Approved");
    }

    @PostMapping("/environmental_guarantee_letter/{taskId}")
    public ResponseEntity<String> createEnvironmentalGuaranteeLetter(@PathVariable String taskId, @RequestBody GuaranteeDTO dto){

        leasingSubprocessService.createEnvironmentalGuaranteeLetter(taskId,mapper.map(dto, Guarantee.class));

        return ResponseEntity.ok(" Environmental Guarantee Letter created");

    }

    @PostMapping("/leasing_guarantee_letter/{taskId}")
    public ResponseEntity<String> createLeasingGuaranteeLetter(@PathVariable String taskId, @RequestBody GuaranteeDTO dto){

        leasingSubprocessService.createLeasingGuaranteeLetter(taskId,mapper.map(dto, Guarantee.class));

        return ResponseEntity.ok(" Leasing Guarantee Letter created");

    }

    @PostMapping("/leasing_resolution/{taskId}")
    public ResponseEntity<String> createLeasingResolution(@PathVariable String taskId, @RequestBody LeasingResolutionDto dto){

        leasingSubprocessService.createLeasingResolution(taskId,mapper.map(dto, LeasingResolution.class));

        return ResponseEntity.ok(" Leasing resolution created");
    }

    @PostMapping("/mining_license/{taskId}")
    public ResponseEntity<String> createMiningLicense(@PathVariable String taskId, @RequestBody MiningLicenseDTO dto){

        leasingSubprocessService.createMiningLicense(taskId,mapper.map(dto, MiningLicense.class));

        return ResponseEntity.ok("Minig License created");
    }

    @PostMapping("/establishment_protocol/{taskId}")
    public ResponseEntity<String> createEstablishmentProtocol(@PathVariable String taskId, @RequestBody EstablishmentProtocolDto dto){

        leasingSubprocessService.createEstablishmentProtocol(taskId,mapper.map(dto,EstablishmentProtocol.class));

        return ResponseEntity.ok("Establishment Protocol Created");
    }

}

package org.koritsas.vinnslu.main.ws.controllers.workflow;

import org.koritsas.vinnslu.main.models.topo.applications.ResearchApplication;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.main.ws.dto.topo.applications.ResearchApplicationDto;
import org.koritsas.vinnslu.main.ws.services.workflow.ResearchApplicationTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/workflow/process/researchApplication")
public class ResearchApplicationTaskController {

    private ResearchApplicationTaskService researchApplicationTaskService;

    private GeometryModelMapper mapper;

    @Autowired
    public ResearchApplicationTaskController(ResearchApplicationTaskService researchApplicationTaskService, GeometryModelMapper mapper) {
        this.researchApplicationTaskService = researchApplicationTaskService;
        this.mapper = mapper;
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> createResearchApplication(@PathVariable String id, @RequestBody ResearchApplicationDto dto) {

        ResearchApplication researchApplication = mapper.map(dto, ResearchApplication.class);

        researchApplicationTaskService.completeResearchApplicationTask(id, researchApplication);

        return ResponseEntity.ok("Completed Research Application task with id" + id + " and variables" + researchApplication.toString());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> completeResearchApplicationWithOpinions(@PathVariable String id, @RequestBody ResearchApplicationDto dto) {

        ResearchApplication researchApplication = mapper.map(dto, ResearchApplication.class);

        researchApplicationTaskService.completeResearchApplicationOpinionsTask(id, researchApplication);

        return ResponseEntity.ok("Completed Research Application Opinions task with id" + id + " and variables" + researchApplication.toString());
    }
}

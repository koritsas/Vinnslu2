package org.koritsas.vinnslu.main.ws.services.workflow;

import org.flowable.engine.TaskService;
import org.koritsas.vinnslu.main.models.topo.applications.ResearchApplication;
import org.koritsas.vinnslu.main.ws.services.applications.ResearchApplicationService;
import org.koritsas.vinnslu.main.ws.services.crud.common.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ResearchApplicationTaskService {

    private OpinionService opinionService;

    private ResearchApplicationService service;

    private TaskService taskService;


    @Autowired
    public ResearchApplicationTaskService(ResearchApplicationService service, TaskService taskService, OpinionService opinionService) {
        this.service = service;
        this.taskService = taskService;
        this.opinionService = opinionService;
    }

    public void completeResearchApplicationTask(String id, ResearchApplication researchApplication) {

        Map<String, Object> variables = new HashMap<>();


        variables.put("researchApplication", service.create(researchApplication));

        taskService.complete(id, variables);
    }

    public void completeResearchApplicationOpinionsTask(String id, ResearchApplication researchApplication) {

        ResearchApplication old = (ResearchApplication) taskService.getVariable(id, "researchApplication");

        opinionService.create(researchApplication.getArmyOpinion());
        opinionService.create(researchApplication.getGeologicalInstituteOpinion());
        opinionService.create(researchApplication.getTopographicalAuthorityOpinion());

        service.update(old.getId(), researchApplication);

    }

}

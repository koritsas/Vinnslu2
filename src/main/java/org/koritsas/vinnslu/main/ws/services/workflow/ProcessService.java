package org.koritsas.vinnslu.main.ws.services.workflow;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.impl.persistence.entity.ExecutionEntity;
import org.flowable.engine.runtime.Execution;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.koritsas.vinnslu.main.models.common.Opinion;
import org.koritsas.vinnslu.main.models.topo.applications.ResearchApplication;
import org.koritsas.vinnslu.main.models.topo.applications.StandardEnvironmentalCommitmentsApplication;
import org.koritsas.vinnslu.main.models.topo.applications.StandardTechnicalCommitmentsApplication;
import org.koritsas.vinnslu.main.ws.services.applications.ResearchApplicationService;
import org.koritsas.vinnslu.main.ws.services.applications.StandardEnvironmentalCommitmentsApplicationService;
import org.koritsas.vinnslu.main.ws.services.applications.StandardTechnicalCommitmentsApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProcessService {

    private TaskService taskService;

    private RuntimeService runtimeService;

    private ResearchApplicationService researchApplicationService;

    private StandardEnvironmentalCommitmentsApplicationService secService;

    private StandardTechnicalCommitmentsApplicationService stcService;


    @Autowired
    public ProcessService(RuntimeService runtimeService, TaskService taskService, ResearchApplicationService researchApplicationService,StandardEnvironmentalCommitmentsApplicationService secService,StandardTechnicalCommitmentsApplicationService stcService) {
        this.runtimeService = runtimeService;
        this.taskService = taskService;
        this.researchApplicationService = researchApplicationService;
        this.secService = secService;
        this.stcService = stcService;
    }


    @Transactional
    public void startProcessWithResearchApplication(ResearchApplication researchApplication){

        Map<String,Object> variables = new HashMap<>();

        variables.put("researchApplication",researchApplicationService.create(researchApplication));

        runtimeService.startProcessInstanceByKey("vinnslu_workflow",variables);

    }


    @Transactional
    public List<Task> getAllTasks(String processId,String taskId){

        if (taskId==null){
            return taskService.createTaskQuery().includeProcessVariables().processInstanceId(processId).list();
        }else{
            return taskService.createTaskQuery().includeProcessVariables().processInstanceId(processId).taskId(taskId).list();
        }

    }


    @Transactional
    public void completeResearchApplicationOpinionsTask(String taskId, ResearchApplication researchApplication){


        ResearchApplication application =researchApplicationService.update(researchApplication.getId(),researchApplication);


       Map<String,Object> variables= taskService.createTaskQuery().taskId(taskId).includeProcessVariables().singleResult().getProcessVariables();

       variables.put("researchApplication",application);


       taskService.complete(taskId,variables);

    }

    @Transactional
    public void completeStandardEnvironmentalCommitmentsApplicationTask(String taskId,StandardEnvironmentalCommitmentsApplication secApplication){

        Map<String,Object> variables = new HashMap<>();

        variables.put("standardEnvironmentalCommitmentsApplication",secService.create(secApplication));

        taskService.complete(taskId,variables);


    }


    @Transactional
    public void completeStandardEnvironmentalCommitmentsOpinionsTask(String taskId,StandardEnvironmentalCommitmentsApplication secApplication){

        Map<String,Object> variables = taskService.createTaskQuery().taskId(taskId).includeProcessVariables().singleResult().getProcessVariables();

        variables.put("standardEnvironmentalCommitmentsApplication",secService.update(secApplication.getId(),secApplication));

        taskService.complete(taskId,variables);

    }




    @Transactional
    public void completeStandardTechnicalCommitmentsApplicationTask(String taskId, StandardTechnicalCommitmentsApplication stcApplication){

        Map<String,Object> variables = new HashMap<>();

        variables.put("standardTechnicalCommitmentsApplication",stcService.create(stcApplication));

        taskService.complete(taskId,variables);

    }


    @Transactional
    public void completeStandardTechnicalCommitmentsOpinionsTask(String taskId, StandardTechnicalCommitmentsApplication stcApplication){

        Map<String,Object> variables = new HashMap<>();

        variables.put("standardTechnicalCommitmentsApplication",stcService.update(stcApplication.getId(),stcApplication));

        taskService.complete(taskId,variables);

    }



}

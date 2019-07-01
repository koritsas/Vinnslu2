package org.koritsas.vinnslu.main.ws.services.workflow;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.impl.persistence.entity.ExecutionEntity;
import org.flowable.engine.runtime.Execution;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.koritsas.vinnslu.main.models.common.Opinion;
import org.koritsas.vinnslu.main.models.topo.applications.ResearchApplication;
import org.koritsas.vinnslu.main.ws.services.applications.ResearchApplicationService;
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


    @Autowired
    public ProcessService(RuntimeService runtimeService, TaskService taskService, ResearchApplicationService researchApplicationService) {
        this.runtimeService = runtimeService;
        this.taskService = taskService;
        this.researchApplicationService = researchApplicationService;
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
    public void completeTask(String taskId,Opinion opinion){


        ResearchApplication researchApplication= (ResearchApplication) taskService.createTaskQuery().includeProcessVariables().taskId(taskId).singleResult().getProcessVariables().get("researchApplication");

        researchApplication.setArmyOpinion(opinion);



       Map<String,Object> variables= taskService.createTaskQuery().taskId(taskId).includeProcessVariables().singleResult().getProcessVariables();

       variables.put("researchApplication",researchApplicationService.update(researchApplication.getId(),researchApplication));


       taskService.complete(taskId,variables);

    }

}

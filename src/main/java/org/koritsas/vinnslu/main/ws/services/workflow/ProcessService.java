package org.koritsas.vinnslu.main.ws.services.workflow;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
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
    public void startProcess(ResearchApplication researchApplication) {

        Map<String, Object> variables = new HashMap<>();

        variables.put("researchApplication", researchApplicationService.create(researchApplication));

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("vinnslu_workflow", variables);

        Map<String, Object> instVars = processInstance.getProcessVariables();

        System.out.println(instVars.get("researchApplication").toString());

    }

    @Transactional
    public List<Task> getProcessInstanceTasks(String processId) {

        return taskService.createTaskQuery().processInstanceId(processId).list();

    }

    @Transactional
    public Task getTaskByIdAndProcessInstance(String processId, String taskId) {

        return taskService.createTaskQuery().processInstanceId(processId).taskId(taskId).singleResult();
    }

    @Transactional
    public Task getTaskById(String id) {
        return taskService.createTaskQuery().taskId(id).singleResult();
    }

    @Transactional
    public List<Task> getTasksByName(String name) {

            return taskService.createTaskQuery().taskName(name).list();
    }

    @Transactional
    public List<Task> getAllTasks() {
        return taskService.createTaskQuery().list();
    }

    @Transactional
    public void completeTask(String processId, String taskId, Object variable) {

        Map<String, Object> variables = new HashMap<>();
        variables.put(variable.getClass().getName(), variable);

        taskService.complete(taskId, variables);
    }

    @Transactional
    public ResearchApplication updateResearcLicenseWithOpinions(String processId, String taskId, List<Opinion> opinions) {

        Execution ed = runtimeService.createExecutionQuery().processInstanceId(processId).singleResult();


        ResearchApplication researchApplication = (ResearchApplication) runtimeService.getVariable(processId, "researchApplication");

        researchApplication.setArmyOpinion(opinions.get(0));
        researchApplication.setTopographicalAuthorityOpinion(opinions.get(1));
        researchApplication.setGeologicalInstituteOpinion(opinions.get(2));

        return researchApplicationService.update(researchApplication.getId(), researchApplication);

    }


    @Transactional
    public void cancelProcess(String id, String reason) {
        runtimeService.deleteProcessInstance(id, reason);
    }



}

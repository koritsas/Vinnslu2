package org.koritsas.vinnslu.main.ws.services.workflow;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
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
        variables.put("ResearchApplication", researchApplicationService.create(researchApplication));

        runtimeService.startProcessInstanceByKey("vinnslu_workflow", variables);


    }

    @Transactional
    public Task getTaskById(String id) {
        return taskService.createTaskQuery().taskId(id).singleResult();
    }

    @Transactional
    public List<Task> getTasks(String name) {

        if (name == null) {
            return taskService.createTaskQuery().list();
        } else {
            return taskService.createTaskQuery().taskName(name).list();
        }


    }

    @Transactional
    public void completeTask(String id, Object variable) {

        Map<String, Object> variables = new HashMap<>();
        variables.put(variable.getClass().getName(), variable);

        taskService.complete(id, variables);
    }


}

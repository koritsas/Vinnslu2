package org.koritsas.vinnslu.main.ws.services.workflow;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class WorkflowService {

    private RuntimeService runtimeService;

    private TaskService taskService;

    @Autowired
    public WorkflowService(RuntimeService runtimeService, TaskService taskService) {
        this.runtimeService = runtimeService;
        this.taskService = taskService;
    }


    @Transactional
    public List<Task> getAllTasks(String processId, String taskId) {


        Optional<String> optional = Optional.ofNullable(taskId);

        if (taskId == null) {
            return taskService.createTaskQuery().includeProcessVariables().processInstanceId(processId).list();
        } else {
            return taskService.createTaskQuery().includeProcessVariables().processInstanceId(processId).taskId(taskId).list();
        }

    }

    public ProcessInstance getProcessInstanceByTopo(Topo topo) {


        ProcessInstance processInstance = this.runtimeService.createProcessInstanceQuery().variableValueEquals("topo", topo).singleResult();

        System.out.println(processInstance.getId());

        return processInstance;
    }


}

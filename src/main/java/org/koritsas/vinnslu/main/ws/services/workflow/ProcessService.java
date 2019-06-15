package org.koritsas.vinnslu.main.ws.services.workflow;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.ws.services.crud.topo.TopoService;
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

    private TopoService topoService;


    @Autowired
    public ProcessService(RuntimeService runtimeService, TaskService taskService,TopoService topoService){
        this.runtimeService=runtimeService;
        this.taskService=taskService;
        this.topoService=topoService;
    }

   @Transactional
    public void startProcess(Topo topo){

        Map<String,Object> variables = new HashMap<>();
        variables.put("topo",topoService.create(topo));

        runtimeService.startProcessInstanceByKey("vinnslu_workflow",variables);



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

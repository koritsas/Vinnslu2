package org.koritsas.vinnslu.main.ws.services.workflow;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;

import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.ws.repos.topo.TopoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ResearchApplicationService {

    private RuntimeService runtimeService;

    private TaskService taskService;

    private TopoRepository topoRepository;

    @Autowired
    public ResearchApplicationService(RuntimeService runtimeService, TaskService taskService,TopoRepository topoRepository){
        this.runtimeService=runtimeService;
        this.taskService = taskService;
        this.topoRepository = topoRepository;
    }

    @Transactional
    public void startProcess(Topo topo){



        Map<String,Object> variables = new HashMap<>();

        variables.put("topo",topo);

        this.runtimeService.startProcessInstanceByKey("start",variables);
    }

    @Transactional
    public List<Task> getTasks(){
        return this.taskService.createTaskQuery().active().list();
    }


}

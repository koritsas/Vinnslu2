package org.koritsas.vinnslu.main.ws.controllers.workflow;

import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.main.utils.TaskRepresentation;
import org.koritsas.vinnslu.main.ws.dto.topo.TopoDTO;
import org.koritsas.vinnslu.main.ws.services.workflow.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/workflow")
public class ProcessController {

    private GeometryModelMapper mapper;

    private ProcessService processService;

    @Autowired
    public ProcessController(ProcessService processService, GeometryModelMapper mapper){
        this.processService = processService;
        this.mapper=mapper;
    }

    @GetMapping("/process/tasks")
    public List<TaskRepresentation> getTasks(){
        List<Task> tasks = processService.getTasks();

        List<TaskRepresentation> taskRepresentations = new ArrayList<>();

        for (Task task:tasks){
            TaskRepresentation taskRepresentation = new TaskRepresentation(task.getId(),task.getName(),task.getProcessInstanceId(),task.getScopeId(),task.getCategory(),task.getOwner(),task.getCreateTime());
            taskRepresentations.add(taskRepresentation);
        }
        return taskRepresentations;
    }


    @PostMapping("/process")
    public void createProcess(@RequestBody TopoDTO dto){

       processService.startProcess(mapper.map(dto, Topo.class));
    }

    @PostMapping("/process/tasks/{id}")
    public ResponseEntity<String> completeTask(@PathVariable String id){

        processService.completeTask(id);


       return ResponseEntity.ok("Task with id "+ id +" successfully completed");
    }



}

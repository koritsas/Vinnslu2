package org.koritsas.vinnslu.main.ws.controllers.workflow;

import org.flowable.task.api.Task;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.models.topo.applications.ResearchApplication;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.main.utils.TaskRepresentation;
import org.koritsas.vinnslu.main.ws.dto.topo.TopoDTO;
import org.koritsas.vinnslu.main.ws.dto.topo.applications.ResearchApplicationDto;
import org.koritsas.vinnslu.main.ws.services.workflow.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/process/tasks/{name}")
    public List<TaskRepresentation> getTasks(@RequestParam(required = false) String name) {
        List<Task> tasks = processService.getTasks(name);


        List<TaskRepresentation> taskRepresentations = new ArrayList<>();

        for (Task task:tasks){
            TaskRepresentation taskRepresentation = new TaskRepresentation(task.getId(),task.getName(),task.getProcessInstanceId(),task.getScopeId(),task.getCategory(),task.getOwner(),task.getCreateTime());
            taskRepresentations.add(taskRepresentation);
        }
        return taskRepresentations;
    }


    @PostMapping("/process")
    public void createProcess(@RequestBody ResearchApplicationDto dto){

       processService.startProcess(mapper.map(dto, ResearchApplication.class));

    }
/*
    @PostMapping("/process/tasks/{id}")
    public ResponseEntity<String> completeTask(@PathVariable String id,@RequestBody String dto){

       Topo t= mapper.map(dto,Topo.class);

        System.out.println(t.toString());

       // processService.completeTask(id);

       return ResponseEntity.ok("Task with id "+ id +" successfully completed");
    }
*/


    @PostMapping("/process/tasks/researchApplication/{id}")
    public ResponseEntity<String> completeResearchApplicationTask(@PathVariable String id, @RequestBody String dto) {

        ResearchApplication application = mapper.map(dto, ResearchApplication.class);

        Map<String, Object> variables = new HashMap<>();

        return null;

    }
}



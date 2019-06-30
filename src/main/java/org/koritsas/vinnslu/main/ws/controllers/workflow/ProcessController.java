package org.koritsas.vinnslu.main.ws.controllers.workflow;

import org.flowable.task.api.Task;
import org.koritsas.vinnslu.main.models.common.Opinion;
import org.koritsas.vinnslu.main.models.topo.applications.ResearchApplication;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.main.utils.TaskRepresentation;
import org.koritsas.vinnslu.main.ws.dto.common.OpinionDTO;
import org.koritsas.vinnslu.main.ws.dto.topo.applications.ResearchApplicationDto;
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
    public ProcessController(ProcessService processService, GeometryModelMapper mapper) {
        this.processService = processService;
        this.mapper = mapper;
    }

    @GetMapping("/process/{processId}/tasks")
    public List<TaskRepresentation> getProcessInstanceTasks(@RequestParam String processId) {

        List<Task> tasks = processService.getProcessInstanceTasks(processId);

        List<TaskRepresentation> taskRepresentations = new ArrayList<>();

        for (Task task : tasks) {
            TaskRepresentation taskRepresentation = new TaskRepresentation(task.getId(), task.getName(), task.getProcessInstanceId(), task.getScopeId(), task.getCategory(), task.getOwner(), task.getCreateTime());
            taskRepresentations.add(taskRepresentation);
        }
        return taskRepresentations;

    }

    @GetMapping("/process/{processId}/tasks/{taskId}")
    public TaskRepresentation getTaskById(@RequestParam String processId, @RequestParam String taskId) {

        Task task = processService.getTaskByIdAndProcessInstance(processId, taskId);
        return new TaskRepresentation(task.getId(), task.getName(), task.getProcessInstanceId(), task.getScopeId(), task.getCategory(), task.getOwner(), task.getCreateTime());
    }




    @GetMapping("/process/tasks/{name}")
    public List<TaskRepresentation> getTasksByName(@RequestParam(required = false) String name) {
        List<Task> tasks = processService.getTasksByName(name);


        List<TaskRepresentation> taskRepresentations = new ArrayList<>();

        for (Task task : tasks) {
            TaskRepresentation taskRepresentation = new TaskRepresentation(task.getId(), task.getName(), task.getProcessInstanceId(), task.getScopeId(), task.getCategory(), task.getOwner(), task.getCreateTime());
            taskRepresentations.add(taskRepresentation);
        }
        return taskRepresentations;
    }

    @GetMapping("/process/tasks")
    public List<TaskRepresentation> getAllTasks() {
        List<Task> tasks = processService.getAllTasks();


        List<TaskRepresentation> taskRepresentations = new ArrayList<>();

        for (Task task : tasks) {
            TaskRepresentation taskRepresentation = new TaskRepresentation(task.getId(), task.getName(), task.getProcessInstanceId(), task.getScopeId(), task.getCategory(), task.getOwner(), task.getCreateTime());
            taskRepresentations.add(taskRepresentation);
        }
        return taskRepresentations;

    }


    @PostMapping("/process")
    public void createProcess(@RequestBody ResearchApplicationDto dto) {

        processService.startProcess(mapper.map(dto, ResearchApplication.class));


    }


    @PostMapping("/process/{processId}/tasks/{taskId}")
    public ResponseEntity<String> completeOpinionsTask(@PathVariable String processId, @PathVariable String taskId, @RequestBody List<OpinionDTO> opinionsDto) {

        List<Opinion> opinions = mapper.map(opinionsDto, List.class);

        processService.updateResearcLicenseWithOpinions(processId, taskId, opinions);


        return ResponseEntity.ok("Task with id " + taskId + " completed");

    }

    @PostMapping("/process/{processId}")
    public ResponseEntity<String> cancelProcessWithId(@PathVariable String id, @RequestBody String reason) {

        processService.cancelProcess(id, reason);

        return ResponseEntity.status(204).body("Process instance with id " + id + "deleted with reason: " + reason);
    }


}



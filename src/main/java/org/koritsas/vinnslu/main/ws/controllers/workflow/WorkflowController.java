package org.koritsas.vinnslu.main.ws.controllers.workflow;

import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.main.utils.ProcessInstanceRepresentation;
import org.koritsas.vinnslu.main.utils.TaskRepresentation;
import org.koritsas.vinnslu.main.ws.dto.topo.TopoDTO;
import org.koritsas.vinnslu.main.ws.services.workflow.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vinnslu/workflow/process")
public class WorkflowController {

    private WorkflowService workflowService;

    private GeometryModelMapper mapper;

    @Autowired
    public WorkflowController(WorkflowService workflowService, GeometryModelMapper mapper) {
        this.workflowService = workflowService;
        this.mapper = mapper;
    }


    @PostMapping("/topo")
    public ResponseEntity<ProcessInstanceRepresentation> getProcessByTopo(@RequestBody TopoDTO dto) {

        ProcessInstance processInstance = workflowService.getProcessInstanceByTopo(mapper.map(dto, Topo.class));


        return ResponseEntity.ok(new ProcessInstanceRepresentation(processInstance));
    }

    @GetMapping("/tasks")
    public List<TaskRepresentation> getAllTasks(@RequestParam(required = false) String processId, @RequestParam(required = false) String taskId) {

        List<Task> tasks = workflowService.getAllTasks(processId, taskId);

        List<TaskRepresentation> taskRepresentations = new ArrayList<>();

        tasks.forEach(task -> {
            TaskRepresentation taskRepresentation = new TaskRepresentation();
            taskRepresentation.setId(task.getId());
            taskRepresentation.setCreateTime(task.getCreateTime());
            taskRepresentation.setCategory(task.getCategory());
            taskRepresentation.setName(task.getName());
            taskRepresentation.setProcessInstanceId(task.getProcessInstanceId());
            taskRepresentation.setScopeId(task.getScopeId());
            taskRepresentation.setProcessVariables(task.getProcessVariables());

            taskRepresentations.add(taskRepresentation);
        });

        return taskRepresentations;
    }
}

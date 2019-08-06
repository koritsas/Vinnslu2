package org.koritsas.vinnslu.main.ws.services.workflow;

import org.flowable.engine.HistoryService;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.utils.ProcessInstanceRepresentation;
import org.koritsas.vinnslu.main.utils.TaskRepresentation;
import org.koritsas.vinnslu.main.ws.services.crud.topo.TopoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class HistoricService {

    private HistoryService historyService;

    private TopoService topoService;

    @Autowired
    public HistoricService(HistoryService historyService, TopoService topoService) {
        this.historyService = historyService;
        this.topoService = topoService;

    }

    @Transactional
    public HistoricProcessInstance getHistoriceProcessInstanceByTopo(Topo topo){
        HistoricProcessInstance instance =  historyService.createHistoricProcessInstanceQuery().variableValueEquals("topo",topo).singleResult();

       return instance;
    }

    @Transactional
    public  HistoricProcessInstance getHistoricProcessInstanceById(String processId){

        return historyService.createHistoricProcessInstanceQuery().processInstanceId(processId).singleResult();
    }

    @Transactional
    public List<HistoricTaskInstance> getAllFinishedTasksFromProcess(String processInstanceId) {

       List<HistoricTaskInstance> finishedTasks =this.historyService.createHistoricTaskInstanceQuery().processInstanceId(processInstanceId).includeProcessVariables()
               .finished()
               .list();


        return finishedTasks;
    }


    @Transactional
    public List<HistoricTaskInstance> getHistoricTasksWithTopo(Topo topo) {

        String historicProcessId = getHistoriceProcessInstanceByTopo(topo).getId();

        List<HistoricTaskInstance> historicTaskInstances = historyService.createHistoricTaskInstanceQuery().processInstanceId(historicProcessId).finished().list();

        return historicTaskInstances;
    }

    @Transactional
    public List<HistoricTaskInstance> getHistoricTaskFromProcessWithTopoId(Long id) {

        Topo topo = topoService.find(id);



        return historyService.createHistoricTaskInstanceQuery().includeProcessVariables().finished().processVariableValueEquals("topo", topo).list();

    }

    @Transactional
    public ProcessInstanceRepresentation getHistoricProcessWithTopoId(Long id) {

        Topo topo = topoService.find(id);

        List<HistoricTaskInstance> finishedTasks = historyService.createHistoricTaskInstanceQuery().finished().processVariableValueEquals("topo", topo).list();

        List<HistoricTaskInstance> activeTasks = historyService.createHistoricTaskInstanceQuery().unfinished().processVariableValueEquals("topo", topo).list();

        HistoricProcessInstance historicProcess = historyService.createHistoricProcessInstanceQuery().includeProcessVariables().variableValueEquals("topo", topo).singleResult();


        List<TaskRepresentation> finishedTasksRepresentation = new ArrayList<>();

        finishedTasks.forEach(f -> finishedTasksRepresentation.add(new TaskRepresentation(f)));


        List<TaskRepresentation> activeTasksRepresentation = new ArrayList<>();

        activeTasks.forEach(a -> activeTasksRepresentation.add(new TaskRepresentation(a)));

        ProcessInstanceRepresentation processInstanceRepresentation = new ProcessInstanceRepresentation(historicProcess);

        processInstanceRepresentation.setActiveTasks(activeTasksRepresentation);

        processInstanceRepresentation.setFinishedTasks(finishedTasksRepresentation);

        return processInstanceRepresentation;
    }


}

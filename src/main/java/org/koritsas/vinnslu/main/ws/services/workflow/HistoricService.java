package org.koritsas.vinnslu.main.ws.services.workflow;

import org.flowable.engine.HistoryService;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.task.api.Task;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.flowable.task.service.HistoricTaskService;
import org.flowable.task.service.impl.HistoricTaskInstanceQueryImpl;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.utils.ProcessInstanceRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HistoricService {

    HistoryService historyService;

    HistoricTaskService historicTaskService;

    @Autowired
    public HistoricService(HistoryService historyService){
        this.historyService = historyService;

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
    public Map<String,List<HistoricTaskInstance>> getAllTasksFromProcess(String processInstanceId){

       List<HistoricTaskInstance> finishedTasks =this.historyService.createHistoricTaskInstanceQuery().processInstanceId(processInstanceId).includeProcessVariables()
               .finished()
               .list();

        List<HistoricTaskInstance> unfinishedTasks =this.historyService.createHistoricTaskInstanceQuery().processInstanceId(processInstanceId).includeProcessVariables()
                .finished()
                .list();

        HashMap<String,List<HistoricTaskInstance>> map = new HashMap<>();


        map.put("finished",finishedTasks);
        map.put("unfinished",unfinishedTasks);


      return map;
    }


}

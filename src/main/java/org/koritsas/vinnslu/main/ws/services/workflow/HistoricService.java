package org.koritsas.vinnslu.main.ws.services.workflow;

import org.flowable.engine.HistoryService;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.task.service.HistoricTaskService;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.utils.ProcessInstanceRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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



}

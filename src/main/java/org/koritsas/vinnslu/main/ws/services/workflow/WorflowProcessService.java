package org.koritsas.vinnslu.main.ws.services.workflow;


import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WorflowProcessService {

    private RuntimeService runtimeService;

    @Autowired
    public WorflowProcessService(RuntimeService runtimeService){

        this.runtimeService = runtimeService;
    }


    @Transactional
    public ProcessInstance getProcessInsanceByTopo(Topo topo) {

        return runtimeService.createProcessInstanceQuery().active().variableValueEquals("topo", topo).singleResult();
    }


    @Transactional
    public List<ProcessInstance> getAllProcessInstances(){

        return runtimeService.createProcessInstanceQuery().includeProcessVariables().list();
    }

    @Transactional
    public ProcessInstance getProcessInstanceById(String processId){

        return runtimeService.createProcessInstanceQuery().includeProcessVariables().processInstanceId(processId).singleResult();
    }

    @Transactional
    public void deleteProcessInstance(String processId, String deleteReason){
        runtimeService.deleteProcessInstance(processId,deleteReason);
    }




}

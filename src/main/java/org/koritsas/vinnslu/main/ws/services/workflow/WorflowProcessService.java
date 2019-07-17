package org.koritsas.vinnslu.main.ws.services.workflow;


import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorflowProcessService {

    private RuntimeService runtimeService;

    public WorflowProcessService(RuntimeService runtimeService){

        this.runtimeService = runtimeService;
    }

    public List<ProcessInstance> getAllProcessInstances(){

        return runtimeService.createProcessInstanceQuery().includeProcessVariables().list();
    }

    public ProcessInstance getProcessInstanceById(String processId){

      return runtimeService.createProcessInstanceQuery().includeProcessVariables().processInstanceId(processId).singleResult();
    }

    public void deleteProcessInstance(String processId, String deleteReason){
        runtimeService.deleteProcessInstance(processId,deleteReason);
    }




}

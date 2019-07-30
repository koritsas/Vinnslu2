package org.koritsas.vinnslu.main.ws.services.workflow;


import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.engine.runtime.ProcessInstanceQuery;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.ws.repos.applications.ResearchApplicationRepository;
import org.koritsas.vinnslu.main.ws.services.crud.topo.TopoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Predicate;

@Service
public class WorkflowProcessService {

    private RuntimeService runtimeService;

    private TopoService topoService;



    @Autowired
    public WorkflowProcessService(RuntimeService runtimeService, ResearchApplicationRepository researchApplicationRepository){

        this.runtimeService = runtimeService;
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

package org.koritsas.vinnslu.main.ws.services.workflow;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkflowService {

    private RuntimeService runtimeService;

    @Autowired
    public WorkflowService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public ProcessInstance getProcessInstanceByTopo(Topo topo) {


        ProcessInstance processInstance = this.runtimeService.createProcessInstanceQuery().variableValueEquals("topo", topo).singleResult();

        System.out.println(processInstance.getId());

        return processInstance;
    }

}

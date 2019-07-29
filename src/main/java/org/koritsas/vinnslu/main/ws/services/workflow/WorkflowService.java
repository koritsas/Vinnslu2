package org.koritsas.vinnslu.main.ws.services.workflow;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class WorkflowService {

    private RuntimeService runtimeService;

    @Autowired
    public WorkflowService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public ProcessInstance getProcessInstanceByTopo(Topo topo) {

        List<ProcessInstance> list = runtimeService.createProcessInstanceQuery().active().list();

        list.removeIf(new Predicate<ProcessInstance>() {
            @Override
            public boolean test(ProcessInstance processInstance) {


                return !processInstance.getProcessVariables().containsValue(topo);
            }
        });

        return this.runtimeService.createProcessInstanceQuery().active().variableValueEquals("topo", topo).singleResult();
    }

}

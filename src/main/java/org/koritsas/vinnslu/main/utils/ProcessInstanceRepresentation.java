package org.koritsas.vinnslu.main.utils;

import lombok.Getter;
import lombok.Setter;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.runtime.ProcessInstance;

import java.util.Date;
import java.util.Map;
@Getter @Setter
public class ProcessInstanceRepresentation {


    private String id;

    private String processInstanceId;

    private String name;

    private String defiditionId;

    private String definitionName;

    private String definitionKey;

    private int definitionVersion;

    private Date startTime;

    private Map<String, Object> processVariables;



    public ProcessInstanceRepresentation(ProcessInstance processInstance) {
        this.id = processInstance.getId();
        this.processInstanceId = processInstance.getProcessInstanceId();
        this.name = processInstance.getName();
        this.defiditionId = processInstance.getProcessDefinitionId();
        this.definitionName = processInstance.getProcessDefinitionName();
        this.definitionKey = processInstance.getProcessDefinitionKey();
        this.definitionVersion = processInstance.getProcessDefinitionVersion();
        this.startTime = processInstance.getStartTime();
        this.processVariables = processInstance.getProcessVariables();
    }

    public ProcessInstanceRepresentation(HistoricProcessInstance processInstance) {
        this.id = processInstance.getId();
        this.processInstanceId = processInstance.getSuperProcessInstanceId();
        this.name = processInstance.getName();
        this.defiditionId = processInstance.getProcessDefinitionId();
        this.definitionName = processInstance.getProcessDefinitionName();
        this.definitionKey = processInstance.getProcessDefinitionKey();
        this.definitionVersion = processInstance.getProcessDefinitionVersion();
        this.startTime = processInstance.getStartTime();
        this.processVariables = processInstance.getProcessVariables();
    }
}

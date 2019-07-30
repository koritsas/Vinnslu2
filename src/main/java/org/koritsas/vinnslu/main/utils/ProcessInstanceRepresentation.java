package org.koritsas.vinnslu.main.utils;

import lombok.Getter;
import lombok.Setter;
import org.flowable.engine.runtime.ProcessInstance;

import java.util.Date;
import java.util.Map;

@Getter @Setter
public class ProcessInstanceRepresentation {

    private String id;

    private String name;

    private String definitionId;

    private String definitionName;

    private String definitionKey;

    private Date startTime;

    private Map<String,Object> processVariables;

    public ProcessInstanceRepresentation(ProcessInstance processInstance){
        this.id = processInstance.getId();
        this.name = processInstance.getName();
        this.definitionId = processInstance.getProcessDefinitionId();
        this.definitionName = processInstance.getProcessDefinitionName();
        this.definitionKey = processInstance.getProcessDefinitionKey();
        this.startTime = processInstance.getStartTime();
        this.processVariables = processInstance.getProcessVariables();

    }

}

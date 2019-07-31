package org.koritsas.vinnslu.main.utils;

import lombok.*;
import org.flowable.task.api.Task;
import org.flowable.task.api.history.HistoricTaskInstance;

import java.util.Date;
import java.util.Map;

@Getter @Setter
public class TaskRepresentation {

    private String id;

    private String name;

    private String processInstanceId;

    private String scopeId;

    private String category;

    private String owner;

    private Date createTime;

    private Map<String,Object> processVariables;


    public TaskRepresentation(Task task){
        this.id = task.getId();
        this.name = task.getName();
        this.processInstanceId = task.getProcessInstanceId();
        this.scopeId = task.getScopeId();
        this.category = task.getCategory();
        this.owner = task.getOwner();
        this.createTime = task.getCreateTime();
        this.processVariables = task.getProcessVariables();
    }

    public TaskRepresentation(HistoricTaskInstance task){
        this.id = task.getId();
        this.name = task.getName();
        this.processInstanceId = task.getProcessInstanceId();
        this.scopeId = task.getScopeId();
        this.category = task.getCategory();
        this.owner = task.getOwner();
        this.createTime = task.getCreateTime();
        this.processVariables = task.getProcessVariables();

    }



}

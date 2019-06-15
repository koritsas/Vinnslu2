package org.koritsas.vinnslu.main.utils;

import org.flowable.task.api.Task;

import java.util.Date;

public class TaskRepresentation {

    private String id;

    private String name;

    private String processInstanceId;

    private String scopeId;

    private String category;

    private String owner;

    private Date createTime;

    public TaskRepresentation(String id, String name,String processInstanceId,String scopeId,String category,String owner,Date createTime) {
        this.id = id;
        this.name = name;
        this.processInstanceId=processInstanceId;
        this.scopeId=scopeId;
        this.category=category;
        this.owner=owner;
        this.createTime=createTime;
    }

    private void helper(Task task){


    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getScopeId() {
        return scopeId;
    }

    public void setScopeId(String scopeId) {
        this.scopeId = scopeId;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

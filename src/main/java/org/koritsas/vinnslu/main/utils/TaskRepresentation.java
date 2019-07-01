package org.koritsas.vinnslu.main.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.flowable.task.api.Task;

import java.util.Date;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskRepresentation {

    private String id;

    private String name;

    private String processInstanceId;

    private String scopeId;

    private String category;

    private String owner;

    private Date createTime;

    private Map<String,Object> processVariables;
}

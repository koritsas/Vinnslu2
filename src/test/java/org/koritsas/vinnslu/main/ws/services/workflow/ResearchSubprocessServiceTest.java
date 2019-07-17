package org.koritsas.vinnslu.main.ws.services.workflow;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.test.FlowableRule;
import org.flowable.spring.impl.test.FlowableSpringExtension;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.koritsas.vinnslu.main.configuration.AppConfiguration;
import org.koritsas.vinnslu.main.configuration.WorkflowConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(FlowableSpringExtension.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfiguration.class, WorkflowConfiguration.class})
public class ResearchSubprocessServiceTest {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;


    @Autowired
    @Rule
    public FlowableRule flowableSpringRule;


    @Test
    public void test() {

        taskService.getSubTasks("fdsaf");

    }

}
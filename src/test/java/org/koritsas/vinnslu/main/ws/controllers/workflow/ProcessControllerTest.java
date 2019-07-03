package org.koritsas.vinnslu.main.ws.controllers.workflow;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.test.Deployment;
import org.flowable.engine.test.FlowableRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)

public class ProcessControllerTest {

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    TaskService taskService;


    @Autowired
    @Rule
    public FlowableRule flowableSpringRule;


    @Test
    @Deployment
    public void testResearchLicenseSubprocess(){

        runtimeService.startProcessInstanceByKey("vinnslu_application");
    }

}
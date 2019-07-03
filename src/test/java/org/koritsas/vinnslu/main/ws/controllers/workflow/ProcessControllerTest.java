package org.koritsas.vinnslu.main.ws.controllers.workflow;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:org/flowable/spring/test/junit4/springTypicalUsageTest-context.xml")
public class ProcessControllerTest {

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    TaskService taskService;






}
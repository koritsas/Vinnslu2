package org.koritsas.vinnslu.main.ws.controllers.workflow;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.test.Deployment;
import org.flowable.engine.test.FlowableRule;
import org.flowable.engine.test.FlowableTest;
import org.flowable.task.api.Task;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.models.topo.applications.ResearchApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@FlowableTest
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProcessControllerTest {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;


    @Before
    public void setUp(){



    }

    @Test
    @Deployment
    public void simpleProcessTest() {

        ResearchApplication researchApplication = new ResearchApplication();

        GeometryFactory factory = new GeometryFactory();
        Polygon polygon = factory.createPolygon(new Coordinate[]{new Coordinate(0,0),new Coordinate(0,1),new Coordinate(1,1),new Coordinate(1,0),new Coordinate(0,0)});

       // Topo topo =new TopoBuilder().abl(666).area(5000.256).forest(true).id(1).location("Sarliki").community("Nees Karies").municipality("Kileler").polygon(polygon).build();


        Topo t = new Topo(1,666,50000.5,polygon,"Nees Karies","Sarliki",)

        runtimeService.startProcessInstanceByKey("vinnslu_workflow");




        Task task = taskService.createTaskQuery().singleResult();
        assertEquals("My Task", task.getName());

        taskService.complete(task.getId());
        assertEquals(0, runtimeService.createProcessInstanceQuery().count());
    }
}
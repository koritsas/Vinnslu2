package org.koritsas.vinnslu.main.configuration;

import org.flowable.spring.integration.Flowable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkflowConfiguration {

    @Bean
    public Flowable getFlowable(){
        return new Flowable();
    }

}

package org.koritsas.vinnslu.main.configuration;

import org.flowable.spring.integration.Flowable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class WorkflowConfiguration {

    @Bean
    public Flowable flowable(){
        return new Flowable();
    }

}

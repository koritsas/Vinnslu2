package org.koritsas.vinnslu.main.configuration;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.text.SimpleDateFormat;


@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@Profile({"production","dev"})
public class AppConfiguration {

    @Bean
    public GeometryModelMapper getGeometryModelMapper() {

        return new GeometryModelMapper();
    }


    @Bean
    public JtsModule jtsModule() {
        return new JtsModule();
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(jtsModule());


        objectMapper.setDateFormat(new StdDateFormat());

        return objectMapper;
    }

}

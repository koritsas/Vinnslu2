package org.koritsas.vinnslu.main.configuration;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@Profile("production")
public class AppConfiguration {

    @Bean
    public GeometryModelMapper getGeometryModelMapper(){

        return new GeometryModelMapper();
    }



  /*  @Bean
    public JtsModule jtsModule()
    {
        return new JtsModule();
    }
*/

}

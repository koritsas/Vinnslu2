package org.koritsas.vinnslu;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.main.ws.dto.topo.GeoTopoDto;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.PropertyMapper;

import javax.print.attribute.standard.Destination;
import javax.xml.transform.Source;

@SpringBootApplication
public class VinnsluApplication {

    public static void main(String[] args) {

        SpringApplication.run(VinnsluApplication.class,args);


        String json ="{\n" +
                "      \"type\": \"Feature\",\n" +
                "      \"geometry\": {\n" +
                "        \"type\": \"Polygon\",\n" +
                "        \"coordinates\": [\n" +
                "          [\n" +
                "            [100.0, 0.0], [101.0, 0.0], [101.0, 1.0],\n" +
                "            [100.0, 1.0], [100.0, 0.0]\n" +
                "          ]\n" +
                "        ]\n" +
                "      },\n" +
                "      \"properties\": {\n" +
                "       \"abl\":666,\n" +
                "       \"location\":\"dsafdsaf\",\n" +
                "       \"prefecture\":\"sadfa\",\n" +
                "       \"municipality\":\"dfasdfa\",\n" +
                "       \"area\":4561.25,\n" +
                "       \"community\":\"dsdsdf\",\n" +
                "       \"forest\":true\n" +
                "      }\n" +
                "}\n" +
                "    ";



/*
        GeometryModelMapper mapper = new GeometryModelMapper();

        GeoTopoDto topoDto = new GeoTopoDto();
        topoDto.setAbl(666L);
        topoDto.setArea(4563.56);
        topoDto.setForest(true);
        topoDto.setCommunity("dadfsaf");
        topoDto.setLocation("asdfa");
        topoDto.setMunicipality("adfsadf");

        Coordinate[] coordinates = new Coordinate[]{new Coordinate(0,0),new Coordinate(1,1),new Coordinate(0,1)};

        GeometryFactory factory =new GeometryFactory();

        topoDto.setPolygon(factory.createPolygon(coordinates));



        Topo t =mapper.map(topoDto,Topo.class);

        System.out.println(t.toString());
*/
    }
}

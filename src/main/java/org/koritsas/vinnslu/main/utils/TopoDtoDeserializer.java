package org.koritsas.vinnslu.main.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.ws.dto.topo.TopoDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TopoDtoDeserializer extends JsonDeserializer<TopoDTO> {


    @Override
    public TopoDTO deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        JsonNode node=p.getCodec().readTree(p);

        Long abl = node.get("properties").get("abl").asLong();
        String location = node.get("properties").get("location").asText();
        String municipality = node.get("properties").get("municipality").asText();
        String prefecture = node.get("properties").get("prefecture").asText();
        String community = node.get("properties").get("community").asText();
        boolean forest = node.get("properties").get("forest").asBoolean();
        double area = node.get("properties").get("area").asDouble();



        String coords = node.get("geometry").get("coordinates").asText();

        JsonNode geometryNode = node.get("geometry").get("coordinates").get(0);

        Coordinate[] coordinates = new Coordinate[geometryNode.size()];

       for (int i=0;i<geometryNode.size();i++){

           coordinates[i] = new Coordinate(geometryNode.get(i).get(0).asDouble(),geometryNode.get(i).get(1).asDouble());
       }



       GeometryFactory factory = new GeometryFactory();

       Polygon polygon =factory.createPolygon(coordinates);

       TopoDTO dto = new TopoDTO();


       ObjectMapper mapper = new ObjectMapper();
       Company topoOwner=  mapper.treeToValue(node.get("properties").get("topoOwner"),Company.class);


       Company areaOwner=  mapper.treeToValue(node.get("properties").get("areaOwner"),Company.class);

       dto.setAbl(abl);
       dto.setPolygon(polygon);
       dto.setCommunity(community);
       dto.setLocation(location);
       dto.setPrefecture(prefecture);
       dto.setForest(forest);
       dto.setMunicipality(municipality);
       dto.setArea(area);
       dto.setTopoOwner(topoOwner);
       dto.setAreaOwner(areaOwner);


       return dto;


    }


}

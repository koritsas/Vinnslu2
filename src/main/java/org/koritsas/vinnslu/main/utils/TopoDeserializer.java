package org.koritsas.vinnslu.main.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.ws.dto.topo.TopoDTO;
import org.koritsas.vinnslu.main.ws.repos.common.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Access;
import java.io.IOException;

public class TopoDeserializer extends JsonDeserializer<TopoDTO> {


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

       dto.setAbl(abl);
       dto.setPolygon(polygon);
       dto.setCommunity(community);
       dto.setLocation(location);
       dto.setPrefecture(prefecture);
       dto.setForest(forest);
       dto.setMunicipality(municipality);
       dto.setArea(area);


        Company topoOwner = parseTopoOwner(node);

        dto.setTopoOwner(topoOwner);

        Company areaOwner = parseAreaOwner(node);

        dto.setAreaOwner(areaOwner);

        return dto;
    }

    private Company parseAreaOwner(JsonNode node) {

        Long areaOwnerId=null;
        if (node.get("properties").get("areaOwner").get("id")!=null) {
            areaOwnerId = node.get("properties").get("areaOwner").get("id").asLong();

            Company areaOwner = new Company();

            areaOwner.setId(areaOwnerId);
            return areaOwner;
        }else{
            Long areaOwnerAfm = node.get("properties").get("areaOwner").get("afm").asLong();
            Long areaOwnerPhone = node.get("properties").get("areaOwner").get("phone").asLong();
            String areaOwnerName = node.get("properties").get("areaOwner").get("name").asText();
            String areaOwnerAddress = node.get("properties").get("areaOwner").get("address").asText();

            Company areaOwner = new Company();
            areaOwner.setId(areaOwnerId);
            areaOwner.setPhone(areaOwnerPhone);
            areaOwner.setName(areaOwnerName);
            areaOwner.setAfm(areaOwnerAfm);
            areaOwner.setAddress(areaOwnerAddress);

            return areaOwner;
        }

    }


    private Company parseTopoOwner(JsonNode node) {
        Long topoOwnerId=null;
        if (node.get("properties").get("topoOwner").get("id")!=null) {
            topoOwnerId = node.get("properties").get("topoOwner").get("id").asLong();
            Company topoOwner = new Company();
            topoOwner.setId(topoOwnerId);
            return topoOwner;
        }else{

            Long topoOwnerAfm = node.get("properties").get("topoOwner").get("afm").asLong();
            Long topoOwnerPhone = node.get("properties").get("topoOwner").get("phone").asLong();
            String topoOwnerName = node.get("properties").get("topoOwner").get("name").asText().toString();
            String topoOwnerAddress = node.get("properties").get("topoOwner").get("address").asText().toString();

            Company topoOwner = new Company();
            topoOwner.setId(topoOwnerId);
            topoOwner.setPhone(topoOwnerPhone);
            topoOwner.setName(topoOwnerName);
            topoOwner.setAfm(topoOwnerAfm);
            topoOwner.setAddress(topoOwnerAddress);

           return topoOwner;
        }

    }

}

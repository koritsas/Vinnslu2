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

import java.io.IOException;

public class TopoDeserializer extends JsonDeserializer<Topo> {

    @Override
    public Topo deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);

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

        for (int i = 0; i < geometryNode.size(); i++) {

            coordinates[i] = new Coordinate(geometryNode.get(i).get(0).asDouble(), geometryNode.get(i).get(1).asDouble());
        }


        GeometryFactory factory = new GeometryFactory();

        Polygon polygon = factory.createPolygon(coordinates);

        Topo topo = new Topo();


        ObjectMapper mapper = new ObjectMapper();
        Company topoOwner = mapper.treeToValue(node.get("properties").get("topoOwner"), Company.class);


        Company areaOwner = mapper.treeToValue(node.get("properties").get("areaOwner"), Company.class);

        topo.setAbl(abl);
        topo.setPolygon(polygon);
        topo.setCommunity(community);
        topo.setLocation(location);
        topo.setPrefecture(prefecture);
        topo.setForest(forest);
        topo.setMunicipality(municipality);
        topo.setArea(area);
        topo.setTopoOwner(topoOwner);
        topo.setAreaOwner(areaOwner);


        return topo;

    }
}

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
import lombok.Getter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.NaturalId;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.topo.Topo;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.IOException;

public class TopoDeserializer extends JsonDeserializer<Topo> {

    Properties properties;

    @Getter
    private static class Properties{
        private Long id;

        private Long abl;


        private double area;

        private String community;


        private String location;


        private String municipality;


        private String prefecture;


        private boolean forest;

        private Company topoOwner;

        private Company areaOwner;


    }

    @Override
    public Topo deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);

        ObjectMapper mapper = new ObjectMapper();

        this.properties=mapper.treeToValue(node.get("properties"),Properties.class);

        Long id = properties.getId();
        Long abl = properties.getAbl();
        String location = properties.getLocation();
        String municipality = properties.getMunicipality();
        String prefecture = properties.getPrefecture();
        String community = properties.getCommunity();
        boolean forest = properties.isForest();
        double area = properties.getArea();
        Company topoOwner = properties.getTopoOwner();
        Company areaOwner = properties.getAreaOwner();


        JsonNode geometryNode = node.get("geometry").get("coordinates").get(0);

        Coordinate[] coordinates = new Coordinate[geometryNode.size()];

        for (int i = 0; i < geometryNode.size(); i++) {

            coordinates[i] = new Coordinate(geometryNode.get(i).get(0).asDouble(), geometryNode.get(i).get(1).asDouble());
        }


        GeometryFactory factory = new GeometryFactory();

        Polygon polygon = factory.createPolygon(coordinates);


        Topo topo = new Topo();


        topo.setId(id);
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

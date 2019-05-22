package org.koritsas.vinnslu.main.ws.dto.topo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.ws.dto.AbstractDto;

import java.util.List;

public abstract class GeoTopoDto implements AbstractDto {


    @JsonProperty("properties")
    private Properties properties;
    @JsonProperty("geometry")
    private Geometry geometry;
    @JsonProperty("type")
    private String type;

    public static class Properties {
        @JsonProperty("forest")
        private boolean forest;
        @JsonProperty("community")
        private String community;
        @JsonProperty("area")
        private double area;
        @JsonProperty("municipality")
        private String municipality;
        @JsonProperty("prefecture")
        private String prefecture;
        @JsonProperty("location")
        private String location;
        @JsonProperty("abl")
        private int abl;
    }

    public static class Geometry {
        @JsonProperty("coordinates")
        private List<List<List<Integer>>> coordinates;
        @JsonProperty("type")
        private String type;
    }

    @Override
    public Object getId() {
        return null;
    }

    @Override
    public Class getClaZZ() {
        return Topo.class;
    }


}

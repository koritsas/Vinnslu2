package org.koritsas.vinnslu.main.ws.dto.topo;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.vividsolutions.jts.geom.Polygon;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.ws.dto.AbstractDto;

import java.util.List;

@JsonIgnoreProperties("type")
public class GeoTopoDto implements AbstractDto<Long> {

    public GeoTopoDto(){
        this.abl=this.properties.getAbl();
        this.area=this.properties.getArea();
        this.location=this.properties.getLocation();
        this.community=this.properties.getCommunity();
        this.prefecture=this.properties.getPrefecture();
        this.forest=this.properties.isForest();

    }

    private int lele;

    private Long id;

    private Long abl;

    private double area;

    @JsonProperty("geometry")
    @JsonDeserialize(contentAs = GeometryDeserializer.class)
    private Polygon polygon;


    private String community;


    private String municipality;


    private String location;


    private String prefecture;


    private boolean forest;


    private Company topoOwner;


    private Company areaOwner;



    @JsonProperty("properties")
    private Properties properties;


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
        private Long abl;

        public boolean isForest() {
            return forest;
        }

        public void setForest(boolean forest) {
            this.forest = forest;

        }

        public String getCommunity() {
            return community;
        }

        public void setCommunity(String community) {
            this.community = community;
        }

        public double getArea() {
            return area;
        }

        public void setArea(double area) {
            this.area = area;
        }

        public String getMunicipality() {
            return municipality;
        }

        public void setMunicipality(String municipality) {
            this.municipality = municipality;
        }

        public String getPrefecture() {
            return prefecture;
        }

        public void setPrefecture(String prefecture) {
            this.prefecture = prefecture;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public Long getAbl() {
            return abl;
        }

        public void setAbl(Long abl) {
            this.abl = abl;
        }
    }

    public Long getAbl(){
        return this.abl;
    }


    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public Class getClaZZ() {
        return Topo.class;
    }


}

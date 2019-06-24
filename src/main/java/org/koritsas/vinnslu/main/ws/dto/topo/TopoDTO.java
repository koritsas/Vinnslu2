package org.koritsas.vinnslu.main.ws.dto.topo;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Polygon;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.ws.dto.AbstractDto;

import java.util.Map;


//@JsonDeserialize(using = TopoDeserializer.class)
//@JsonDeserialize(using = GeometryDeserializer.class)

@JsonIgnoreProperties({"type"})
public class TopoDTO implements AbstractDto<Long> {


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;


    private Long abl;

    @JsonProperty("geometry")
    @JsonDeserialize(contentAs = GeometryDeserializer.class)
    private Polygon polygon;


    private String community;


    private String municipality;


    private String location;


    private String prefecture;


    private boolean forest;


    @JsonUnwrapped
    private Company topoOwner;


    @JsonUnwrapped
    private Company areaOwner;


    @SuppressWarnings("unchecked")
    @JsonProperty("properties")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonUnwrapped
    private void unpackProperties(Map<String, Object> properties) {


/*
        System.out.println("LEEEEEEEEEEEEEEELELELELELELELELELELELLELELELEL");
        System.out.println(properties.get("abl"));
        System.out.println(properties.get("community"));
        System.out.println(properties.get("municipality"));
        System.out.println(properties.get("location"));
        System.out.println(properties.get("prefecture"));
        System.out.println(properties.get("forest"));
        System.out.println(properties.get("topoOwner"));




       if (properties.get("id")!=null){
            this.id= Long.valueOf((Long) properties.get("id")).longValue();
        }


        this.abl= Long.valueOf((Integer) properties.get("abl")).longValue();
        this.community= (String) properties.get("community");
        this.municipality= (String) properties.get("municipality");
        this.location= (String) properties.get("location");
        this.prefecture= (String) properties.get("prefecture");
        this.forest= (boolean) properties.get("forest");

       // Map<String,Object>  topoOwner= (Map<String, Object>) properties.get("topoOwner");

*/

        // this.areaOwner = (Company) properties.get("areaOwner");
    }

    @JsonUnwrapped
    private Object getIfNotNull(String key, Map<String, Object> properties) {


        if (properties.get(key) != null) {
            return properties.get(key);
        } else {
            return "";
        }


    }

    public Coordinate[] getCoordinates() {
        return this.polygon.getCoordinates();
    }

    public Long getId() {
        return id;
    }

    @Override
    public Class getClaZZ() {
        return Topo.class;
    }

    @JsonSetter("id")
    public void setId(Long id) {
        this.id = id;
    }

    public boolean isForest() {
        return forest;
    }

    public Long getAbl() { return abl; }

    @JsonSetter("abl")
    public void setAbl(Long abl) { this.abl = abl; }

    public Polygon getPolygon() { return polygon; }

    public void setPolygon(Polygon polygon) { this.polygon = polygon; }

    public String getCommunity() { return community; }

    @JsonSetter("community")
    public void setCommunity(String community) { this.community = community; }

    public String getLocation() { return location; }

    @JsonSetter("location")
    public void setLocation(String location) { this.location = location; }

    public String getPrefecture() { return prefecture; }

    @JsonSetter("prefecture")
    public void setPrefecture(String prefecture) { this.prefecture = prefecture; }

    public boolean getForest() { return forest; }

    @JsonSetter("forest")
    public void setForest(boolean forest) { this.forest = forest; }

    public Company getTopoOwner() { return topoOwner; }

    @JsonSetter("topoOwner")
    public void setTopoOwner(Company topoOwner) { this.topoOwner = topoOwner; }

    public String getMunicipality() {
        return municipality;
    }

    @JsonSetter("municipality")
    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public Company getAreaOwner() { return areaOwner; }

    @JsonSetter("areaOwner")
    public void setAreaOwner(Company areaOwner) { this.areaOwner = areaOwner; }

    @Override
    public String toString() {
        return "TopoDTO{" +
                "abl=" + abl +
                ", polygon=" + polygon +
                ", community='" + community + '\'' +
                ", municipality='" + municipality + '\'' +
                ", location='" + location + '\'' +
                ", prefecture='" + prefecture + '\'' +
                ", forest=" + forest +
                ", topoOwner=" + topoOwner +
                ", areaOwner=" + areaOwner +
                '}';
    }
}

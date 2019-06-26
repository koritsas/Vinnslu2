package org.koritsas.vinnslu.main.ws.dto.topo;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Polygon;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.utils.TopoDeserializer;
import org.koritsas.vinnslu.main.ws.dto.AbstractDto;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


//@JsonDeserialize(using = TopoDeserializer.class)
//@JsonDeserialize(using = GeometryDeserializer.class)

@JsonDeserialize(using = TopoDeserializer.class)
@JsonIgnoreProperties({"type"})
public class TopoDTO implements AbstractDto<Long> {


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
            this.id= Long.valueOf(properties.get("id").toString());
        }


        if (properties.get("abl")!=null){
            this.abl= Long.valueOf(properties.get("abl").toString());
        }

        if (properties.get("community")!=null){
            this.community= (String) properties.get("community");
        }

        if (properties.get("municipality")!=null){
            this.municipality= (String) properties.get("municipality");
        }

        if (properties.get("location")!=null){
            this.location= (String) properties.get("location");
        }

        if(properties.get("prefecture")!=null){
            this.prefecture= (String) properties.get("prefecture");
        }

        if (properties.get("forest")!=null){
            this.forest= (boolean) properties.get("forest");
        }


        ObjectMapper mapper = new ObjectMapper();

        try {

            System.out.println("---------------------ENTERED TRY CLAUSE____________________");
            this.topoOwner = mapper.readValue(properties.get("topoOwner").toString(),Company.class);

            System.out.println(topoOwner.toString());

            this.areaOwner = mapper.readValue(properties.get("areaOwner").toString(),Company.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

/*
        Map<String,String> topoOwnerMap = (Map<String, String>) properties.get("topoOwner");


        this.topoOwner.setAddress(topoOwnerMap.get("address"));
        this.topoOwner.setAfm(Long.valueOf(topoOwnerMap.get("afm")));
        this.topoOwner.setName(topoOwnerMap.get("name"));
        this.topoOwner.setPhone(Long.valueOf(topoOwnerMap.get("phone")));



        Map<String,String> areaOwnerMap = (Map<String, String>) properties.get("areaOwner");


        this.areaOwner.setAddress(topoOwnerMap.get("address"));
        this.areaOwner.setAfm(Long.valueOf(topoOwnerMap.get("afm")));
        this.areaOwner.setName(topoOwnerMap.get("name"));
        this.areaOwner.setPhone(Long.valueOf(topoOwnerMap.get("phone")));
*/



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



    public void setId(Long id) {
        this.id = id;
    }

    public boolean isForest() {
        return forest;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Long getAbl() { return abl; }


    public void setAbl(Long abl) { this.abl = abl; }

    public Polygon getPolygon() { return polygon; }

    public void setPolygon(Polygon polygon) { this.polygon = polygon; }

    public String getCommunity() { return community; }

    public void setCommunity(String community) { this.community = community; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public String getPrefecture() { return prefecture; }

    public void setPrefecture(String prefecture) { this.prefecture = prefecture; }

    public boolean getForest() { return forest; }

    public void setForest(boolean forest) { this.forest = forest; }

    public Company getTopoOwner() { return topoOwner; }

    public void setTopoOwner(Company topoOwner) { this.topoOwner = topoOwner; }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public Company getAreaOwner() { return areaOwner; }


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

package org.koritsas.vinnslu.main.dto;

import com.vividsolutions.jts.geom.Polygon;
import org.koritsas.vinnslu.main.models.common.Company;


public class TopoDTO {

    private Long id;

    private Long abl;

    private double area;

    private Polygon polygon;

    private String community;

    private String location;

    private String municipality;

    private String prefecture;

    private Company topoOwner;

    private Company owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAbl() {
        return abl;
    }

    public void setAbl(Long abl) {
        this.abl = abl;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public void setPolygon(Polygon polygon) {
        this.polygon = polygon;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public Company getTopoOwner() {
        return topoOwner;
    }

    public void setTopoOwner(Company topoOwner) {
        this.topoOwner = topoOwner;
    }

    public Company getOwner() {
        return owner;
    }

    public void setOwner(Company owner) {
        this.owner = owner;
    }
}

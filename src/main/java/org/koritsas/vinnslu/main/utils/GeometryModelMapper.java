package org.koritsas.vinnslu.main.utils;


import com.fasterxml.jackson.databind.JsonNode;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.ws.dto.topo.GeoTopoDto;
import org.koritsas.vinnslu.main.ws.dto.topo.TopoDTO;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.spi.MappingContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeometryModelMapper extends ModelMapper {


    public GeometryModelMapper() {
/*
        TypeMap<GeoTopoDto,Topo> typeMap=this.createTypeMap(GeoTopoDto.class, Topo.class);
        typeMap.addMapping(GeoTopoDto::getArea,Topo::setArea);
        typeMap.addMapping(GeoTopoDto::getAbl,Topo::setAbl);
        typeMap.addMapping(GeoTopoDto::getPolygon,Topo::setPolygon);
        typeMap.addMapping(GeoTopoDto::getCommunity,Topo::setCommunity);
        typeMap.addMapping(GeoTopoDto::getLocation,Topo::setLocation);
        typeMap.addMapping(GeoTopoDto::getMunicipality,Topo::setMunicipality);
        typeMap.addMapping(GeoTopoDto::getPrefecture,Topo::setPrefecture);
        typeMap.addMapping(GeoTopoDto::getForest,Topo::setForest);
*/
    }


}
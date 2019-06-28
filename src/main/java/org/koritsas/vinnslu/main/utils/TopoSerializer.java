package org.koritsas.vinnslu.main.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.vividsolutions.jts.geom.Coordinate;
import org.koritsas.vinnslu.main.models.topo.Topo;

import java.io.IOException;

public class TopoSerializer extends StdSerializer<Topo> {

    public TopoSerializer() {
        this(null);
    }


    public TopoSerializer(Class<Topo> t) {
        super(t);
    }

    @Override
    public void serialize(Topo value, JsonGenerator gen, SerializerProvider provider) throws IOException {

        //{
        gen.writeStartObject();


        // "type":"Feature"
        gen.writeStringField("type", "Feature");

        gen.writeFieldName("geometry");
        gen.writeStartObject();
        gen.writeStringField("type", value.getPolygon().getGeometryType());
        gen.writeFieldName("coordinates");
        gen.writeStartArray();
        gen.writeStartArray();
        for (Coordinate coordinate : value.getPolygon().getCoordinates()) {
            gen.writeArray(new double[]{coordinate.x, coordinate.y}, 0, 2);
        }
        gen.writeEndArray();
        gen.writeEndArray();
        gen.writeEndObject();
        //properties
        gen.writeFieldName("properties");
        gen.writeStartObject();
        gen.writeNumberField("id", value.getId());
        gen.writeNumberField("abl", value.getAbl());
        gen.writeNumberField("area", value.getArea());
        gen.writeStringField("community", value.getCommunity());
        gen.writeStringField("location", value.getLocation());
        gen.writeStringField("prefecture", value.getPrefecture());
        gen.writeStringField("municipality", value.getMunicipality());
        gen.writeBooleanField("forest", value.isForest());
        gen.writeObjectField("topoOwner", value.getTopoOwner());
        gen.writeObjectField("areaOwner", value.getAreaOwner());
        gen.writeEndObject();


        //}
        gen.writeEndObject();


    }
}

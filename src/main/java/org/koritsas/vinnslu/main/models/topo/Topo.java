package org.koritsas.vinnslu.main.models.topo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Polygon;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.utils.TopoSerializer;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
@Entity
@JsonSerialize(using = TopoSerializer.class)
public class Topo implements Serializable {

    @Id
    @GenericGenerator(
            name = "topo_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "topo_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "topo_generator")
    private Long id;

    @NaturalId
    private Long abl;

    @Max(value = 300000)
    private double area;

    @NotNull
    private Polygon polygon;

    @NotNull
    private String community;

    @NotNull
    private String location;

    @NotNull
    private String municipality;

    @NotNull
    private String prefecture;

    @NotNull
    private boolean forest;


    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.PERSIST})
    @JoinColumn(referencedColumnName = "id", foreignKey = @ForeignKey(name = "TOPO_OWNER_FK"))
    private Company topoOwner;

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.PERSIST})
    @JoinColumn(referencedColumnName = "id", foreignKey = @ForeignKey(name = "AREA_OWNER_FK"))
    private Company areaOwner;




}

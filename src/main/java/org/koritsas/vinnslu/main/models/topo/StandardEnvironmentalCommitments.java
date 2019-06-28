package org.koritsas.vinnslu.main.models.topo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.models.common.Opinion;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class StandardEnvironmentalCommitments implements Serializable {

    @Id
    @GenericGenerator(
            name = "ppd_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "ppd_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "ppd_generator")
    private Long id;

    private boolean active;

    private String protocol;

    private String ada;

    @ManyToOne
    @JoinColumn(name = "city_planning_opinion_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "CP_PPD_OPINION_ID_FK"))
    private Opinion cityPlanningOpinion;

    @ManyToOne
    @JoinColumn(name = "forestry_opinion_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FORESTRY_PPD_OPINION_ID_FK"))
    private Opinion forestryOpinion;

    @ManyToOne
    @JoinColumn(name = "archeology_opinion_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "ARCHEOLOGY_PPD_OPINION_ID_FK"))
    private Opinion archeologyOpinion;

    @ManyToOne
    @JoinColumn(name = "speleology_opinion_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "SPELEOLOGY_PPD_OPINION_ID_FK"))
    private Opinion speleologyOpinion;

    @ManyToOne
    @JoinColumn(name = "topo_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "PPD_TOPO_ID_FK"))
    private Topo topo;

    @Lazy
    @ManyToOne
    @JoinColumn(name = "document", referencedColumnName = "id", foreignKey = @ForeignKey(name = "SEC_DOCUMENT_ID"))
    private Document document;


}

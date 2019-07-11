package org.koritsas.vinnslu.main.models.topo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.koritsas.vinnslu.main.models.common.Document;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class TechnicalStudy implements Serializable {

    @Id
    @GenericGenerator(
            name = "tech_study_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "tech_study_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "tech_study_generator")
    private Long id;

    private boolean active;

    private String protocol;

    private String ada;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Lazy
    @ManyToOne
    @JoinColumn(name = "topo_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "TECHNICAL_STUDY_TOPO_FK"))
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
    private Topo topo;

    @Lazy
    @ManyToOne
    @JoinColumn(name = "environmental_impact_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "TECHNICAL_STUDY_ENV_FK"))
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
    private EnvironmentalImpactStudy environmentalImpactStudy;


    @Lazy
    @ManyToOne
    @JoinColumn(name = "document_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "TECHNICAL_STUDY_DOC_FK"))
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
    private Document document;



}

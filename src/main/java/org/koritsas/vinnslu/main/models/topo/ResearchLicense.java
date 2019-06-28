package org.koritsas.vinnslu.main.models.topo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
public class ResearchLicense implements Serializable {

    @Id
    @GenericGenerator(
            name = "research_license_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "research_license_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "research_license_generator")
    private Long id;

    private String protocol;

    @Column(unique = true)
    private String ada;

    private boolean active;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Lazy
    @ManyToOne
    @JoinColumn(name = "sec_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "RESEARCH_SEC_ID"))
    private StandardEnvironmentalCommitments standardEnvironmentalCommitments;

    @Lazy
    @ManyToOne
    @JoinColumn(name = "stc_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "RESEARCH_STC_ID"))
    private StandardTechnicalCommitments standardTechnicalCommitments;


    @Lazy
    @ManyToOne
    @JoinColumn(name = "topo_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "RESEARCH_TOPO_ID"))
    private Topo topo;

    @Lazy
    @ManyToOne
    @JoinColumn(name = "document_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "RESEARCH_DOC_ID"))
    private Document document;


}

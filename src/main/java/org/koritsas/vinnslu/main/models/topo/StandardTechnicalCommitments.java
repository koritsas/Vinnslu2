package org.koritsas.vinnslu.main.models.topo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.models.common.Opinion;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class StandardTechnicalCommitments implements Serializable {

    @Id
    @GenericGenerator(
            name = "stc_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "stc_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "stc_generator")
    private Long id;

    private boolean active;

    private String protocol;

    private String ada;

    @ManyToOne
    @JoinColumn(name = "topo_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "PTD_TOPO_ID_FK"))
    private Topo topo;

    @ManyToOne
    @JoinColumn(name = "opinions_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "PTD_OPINIONS_ID_FK"))
    private Opinion miningInspectionOpinion;


    @ManyToOne
    @JoinColumn(name = "document", referencedColumnName = "id", foreignKey = @ForeignKey(name = "STC_DOCUMENT_ID"))
    private Document document;

}

package org.koritsas.vinnslu.main.models.topo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.koritsas.vinnslu.main.models.common.Authority;
import org.koritsas.vinnslu.main.models.common.Document;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class LeasingResolution implements Serializable {

    @Id
    @GenericGenerator(
            name = "lease_resolution_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "lease_resolution_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "lease_resolution_generator")
    private Long id;

    @Column(unique = true)
    private String ada;

    private String protocol;

    @ManyToOne
    @JoinColumn(name = "sender_id",referencedColumnName = "id",foreignKey = @ForeignKey(name="LR_S_FK"))
    @Cascade({org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.REFRESH})
    private Authority sender;

    @Lazy
    @ManyToOne
    @JoinColumn(name = "document_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "LR_DOC_FK"))
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
    private Document document;

}

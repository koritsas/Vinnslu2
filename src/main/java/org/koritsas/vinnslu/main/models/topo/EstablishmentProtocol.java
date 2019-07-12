package org.koritsas.vinnslu.main.models.topo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.koritsas.vinnslu.main.models.common.Authority;
import org.koritsas.vinnslu.main.models.common.Company;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstablishmentProtocol implements Serializable {

    @Id
    @GenericGenerator(
            name = "est_protocol_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "est_protocol_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "est_protocol_generator")
    private Long id;

    private String protocol;

    @ManyToOne
    @Cascade({CascadeType.MERGE,CascadeType.PERSIST})
    private Company receiver;

    @ManyToOne
    @Cascade({CascadeType.MERGE,CascadeType.PERSIST})
    private Authority sender;

    @OneToOne
    @Cascade({CascadeType.REFRESH,CascadeType.REFRESH})
    private Topo topo;

}

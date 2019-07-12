package org.koritsas.vinnslu.main.models.topo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Parameter;
import org.koritsas.vinnslu.main.models.types.Contract;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class MiningLicense implements Serializable {

    @Id
    @GenericGenerator(
            name = "min_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "min_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "min_generator")
    private Long id;


    private boolean active;

    private String protocol;

    @Embedded
    @Column(unique = true)
    private Contract contract;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;


    @ManyToOne
    @JoinColumn(name = "technical_study_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "MINING_LICENSE_TECHNICAL_STUDY_ID"))
    private TechnicalStudy technicalStudy;

    @ManyToOne
    @JoinColumn(name = "topo_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "MINING_LICENSE_TOPO_ID"))
    private Topo topo;

    @ManyToOne
    @JoinColumn(name = "environmental_guarantee_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "MINING_LICENSE_ENVIRONMENTAL_GUARANTEE_ID"))
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
    private Guarantee environmentalGuarantee;

    @ManyToOne
    @JoinColumn(name = "lease_guarantee_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "MINING_LICENSE_LEASE_GUARANTEE_ID"))
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
    private Guarantee leaseGuarantee;



}

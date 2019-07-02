package org.koritsas.vinnslu.main.models.topo.applications;


import lombok.*;
import org.hibernate.annotations.Cascade;
import org.koritsas.vinnslu.main.models.common.Opinion;
import org.koritsas.vinnslu.main.models.topo.StandardTechnicalCommitments;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class StandardTechnicalCommitmentsApplication extends Application {

    @OneToOne
    @JoinColumn(name = "standard_technical_commitmens_id")
    private StandardTechnicalCommitments standardTechnicalCommitments;

    @ManyToOne
    @JoinColumn(name = "mining_overseeing_opinion_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "STC_MIN_FK"))
    @Cascade({org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.MERGE})
    private Opinion mineOverseeingOpinion;

    @OneToOne
    @JoinColumn(name = "research_application_id",referencedColumnName = "id",foreignKey = @ForeignKey(name="STCAPP_RAPP_FK"))
    private ResearchApplication researchApplication;

}

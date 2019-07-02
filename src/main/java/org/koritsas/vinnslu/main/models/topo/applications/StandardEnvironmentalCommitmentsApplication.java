package org.koritsas.vinnslu.main.models.topo.applications;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.koritsas.vinnslu.main.models.common.Opinion;
import org.koritsas.vinnslu.main.models.topo.StandardEnvironmentalCommitments;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class StandardEnvironmentalCommitmentsApplication extends Application {

    @ManyToOne
    @JoinColumn(name = "standard_environmental_commitments_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "SEC_APP_FK"))
    private StandardEnvironmentalCommitments standardEnvironmentalCommitments;


    @ManyToOne
    @JoinColumn(name = "foresty_opinion_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "SEC_FO_FK"))
    @Cascade({org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.MERGE})
    private Opinion forestryOpinion;

    @ManyToOne
    @JoinColumn(name = "speleology_opinion_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "SEC_SP_FK"))
    @Cascade({org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.MERGE})
    private Opinion speleologyOpinion;

    @ManyToOne
    @JoinColumn(name = "archeology_opinion_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "SEC_ARCH_FK"))
    @Cascade({org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.MERGE})
    private Opinion archeologyOpinion;

    @ManyToOne
    @JoinColumn(name = "city_planning_opinion_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "SEC_CP_FK"))
    @Cascade({org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.MERGE})
    private Opinion cityPlanningOpinion;

    @OneToOne
    @JoinColumn(name = "research_application_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "SECAPP_RAPP_FK"))
    private ResearchApplication researchApplication;



}

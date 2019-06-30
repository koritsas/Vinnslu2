package org.koritsas.vinnslu.main.models.topo.applications;

import lombok.*;
import org.koritsas.vinnslu.main.models.common.Opinion;
import org.koritsas.vinnslu.main.models.topo.StandardEnvironmentalCommitments;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class StandardEnvironmentalCommitmentsApplication extends Application {

    @ManyToOne
    @JoinColumn(name = "standard_environmental_commitments_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "SEC_APP_FK"))
    private StandardEnvironmentalCommitments standardEnvironmentalCommitments;


    public StandardEnvironmentalCommitments getStandardEnvironmentalCommitments() {
        return standardEnvironmentalCommitments;
    }

    public void setStandardEnvironmentalCommitments(StandardEnvironmentalCommitments standardEnvironmentalCommitments) {
        this.standardEnvironmentalCommitments = standardEnvironmentalCommitments;
    }

    @ManyToOne
    @JoinColumn(name = "foresty_opinion_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "SEC_FO_FK"))
    private Opinion forestryOpinion;

    @ManyToOne
    @JoinColumn(name = "speleology_opinion_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "SEC_SP_FK"))
    private Opinion speleologyOpinion;

    @ManyToOne
    @JoinColumn(name = "archeology_opinion_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "SEC_ARCH_FK"))
    private Opinion archeologyOpinion;

    @ManyToOne
    @JoinColumn(name = "city_planning_opinion_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "SEC_CP_FK"))
    private Opinion cityPlanningOpinion;


}

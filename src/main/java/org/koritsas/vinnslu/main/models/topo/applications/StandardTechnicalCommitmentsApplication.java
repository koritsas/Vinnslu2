package org.koritsas.vinnslu.main.models.topo.applications;


import lombok.*;
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
    private StandardTechnicalCommitments standardTechnicalCommitments;

    @ManyToOne
    @JoinColumn(name = "mining_overseeing_opinion_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "STC_MIN_FK"))
    private Opinion mineOverseeingOpinion;

}

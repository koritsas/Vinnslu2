package org.koritsas.vinnslu.main.models.topo.applications;


import lombok.*;
import org.hibernate.annotations.Cascade;
import org.koritsas.vinnslu.main.models.common.Opinion;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class StandardTechnicalCommitmentsApplication extends Application {


    @ManyToOne
    @JoinColumn(name = "mining_overseeing_opinion_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "STC_MIN_FK"))
    @Cascade({org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.MERGE})
    private Opinion mineOverseeingOpinion;


}

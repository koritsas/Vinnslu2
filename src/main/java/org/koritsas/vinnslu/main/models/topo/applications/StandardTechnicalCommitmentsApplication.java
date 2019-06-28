package org.koritsas.vinnslu.main.models.topo.applications;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.koritsas.vinnslu.main.models.common.Authority;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.models.common.Opinion;
import org.koritsas.vinnslu.main.models.topo.StandardTechnicalCommitments;
import org.koritsas.vinnslu.main.models.topo.Topo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Data
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

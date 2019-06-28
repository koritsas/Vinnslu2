package org.koritsas.vinnslu.main.models.topo.applications;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.koritsas.vinnslu.main.models.common.Authority;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.models.common.Opinion;
import org.koritsas.vinnslu.main.models.topo.ResearchLicense;
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
public class ResearchApplication extends Application {

    @ManyToOne(targetEntity = ResearchLicense.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "research_license_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "RESEARCH_APP_FK"))
    private ResearchLicense researchLicense;


    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Opinion topographicalAuthorityOpinion;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Opinion geologicalInstituteOpinion;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Opinion armyOpinion;

}

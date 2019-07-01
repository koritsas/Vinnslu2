package org.koritsas.vinnslu.main.models.topo.applications;

import lombok.*;
import org.koritsas.vinnslu.main.models.common.Opinion;
import org.koritsas.vinnslu.main.models.topo.ResearchLicense;

import javax.persistence.*;
@Data
@EqualsAndHashCode(callSuper = true)
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

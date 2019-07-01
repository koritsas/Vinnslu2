package org.koritsas.vinnslu.main.models.topo.applications;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.koritsas.vinnslu.main.models.common.Opinion;
import org.koritsas.vinnslu.main.models.topo.ResearchLicense;

import javax.persistence.*;
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ResearchApplication extends Application {

    @ManyToOne(targetEntity = ResearchLicense.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "research_license_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "RESEARCH_APP_FK"))
    private ResearchLicense researchLicense;


    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
    private Opinion topographicalAuthorityOpinion;

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
    private Opinion geologicalInstituteOpinion;

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
    private Opinion armyOpinion;

}

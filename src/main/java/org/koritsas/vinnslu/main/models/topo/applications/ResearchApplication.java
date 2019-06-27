package org.koritsas.vinnslu.main.models.topo.applications;

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

@Entity
public class ResearchApplication extends Application {

    @ManyToOne(targetEntity = ResearchLicense.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "research_license_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "RESEARCH_APP_FK"))
    private ResearchLicense researchLicense;


    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    private Opinion topographicalAuthorityOpinion;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    private Opinion geologicalInstituteOpinion;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    private Opinion armyOpinion;

    public ResearchApplication() {
    }

    public ResearchApplication(String protocol, Company sender, Authority receiver, @NotNull Topo topo, Date applicationDate, Document document, ResearchLicense researchLicense, Opinion topographicalAuthorityOpinion, Opinion geologicalInstituteOpinion, Opinion armyOpinion) {
        super(protocol, sender, receiver, topo, applicationDate, document);
        this.researchLicense = researchLicense;
        this.topographicalAuthorityOpinion = topographicalAuthorityOpinion;
        this.geologicalInstituteOpinion = geologicalInstituteOpinion;
        this.armyOpinion = armyOpinion;
    }

    public Opinion getTopographicalAuthorityOpinion() {
        return topographicalAuthorityOpinion;
    }

    public void setTopographicalAuthorityOpinion(Opinion topographicalAuthorityOpinion) {
        this.topographicalAuthorityOpinion = topographicalAuthorityOpinion;
    }

    public Opinion getGeologicalInstituteOpinion() {
        return geologicalInstituteOpinion;
    }

    public void setGeologicalInstituteOpinion(Opinion geologicalInstituteOpinion) {
        this.geologicalInstituteOpinion = geologicalInstituteOpinion;
    }

    public Opinion getArmyOpinion() {
        return armyOpinion;
    }

    public void setArmyOpinion(Opinion armyOpinion) {
        this.armyOpinion = armyOpinion;
    }

    public ResearchLicense getResearchLicense() {
        return researchLicense;
    }

    public void setResearchLicense(ResearchLicense researchLicense) {
        this.researchLicense = researchLicense;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResearchApplication)) return false;
        if (!super.equals(o)) return false;
        ResearchApplication that = (ResearchApplication) o;
        return Objects.equals(researchLicense, that.researchLicense) &&
                Objects.equals(topographicalAuthorityOpinion, that.topographicalAuthorityOpinion) &&
                Objects.equals(geologicalInstituteOpinion, that.geologicalInstituteOpinion) &&
                Objects.equals(armyOpinion, that.armyOpinion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), researchLicense, topographicalAuthorityOpinion, geologicalInstituteOpinion, armyOpinion);
    }

    @Override
    public String toString() {
        return "ResearchApplication{" +
                "researchLicense=" + researchLicense +
                ", topographicalAuthorityOpinion=" + topographicalAuthorityOpinion +
                ", geologicalInstituteOpinion=" + geologicalInstituteOpinion +
                ", armyOpinion=" + armyOpinion +
                "} " + super.toString();
    }
}

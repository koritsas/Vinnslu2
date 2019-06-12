package org.koritsas.vinnslu.main.models.topo.applications;

import org.koritsas.vinnslu.main.models.common.Authority;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.models.topo.ResearchLicense;
import org.koritsas.vinnslu.main.models.topo.Topo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class ResearchApplication extends Application {

    @ManyToOne(targetEntity = ResearchLicense.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "research_license_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "RESEARCH_APP_FK"))
    private ResearchLicense researchLicense;

    public ResearchApplication() {
    }

    public ResearchApplication(String protocol, Company sender, Authority receiver, @NotNull Topo topo, Document document, ResearchLicense researchLicense) {
        super(protocol, sender, receiver, topo, document);
        this.researchLicense = researchLicense;
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
        return Objects.equals(researchLicense, that.researchLicense);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), researchLicense);
    }

    @Override
    public String toString() {
        return "ResearchApplication{" +
                "researchLicense=" + researchLicense +
                "} " + super.toString();
    }
}

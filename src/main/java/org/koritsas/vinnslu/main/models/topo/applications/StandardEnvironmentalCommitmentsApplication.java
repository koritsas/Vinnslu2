package org.koritsas.vinnslu.main.models.topo.applications;

import org.koritsas.vinnslu.main.models.common.Authority;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.models.common.Opinion;
import org.koritsas.vinnslu.main.models.topo.StandardEnvironmentalCommitments;
import org.koritsas.vinnslu.main.models.topo.Topo;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

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

    public StandardEnvironmentalCommitmentsApplication(String protocol, Company sender, Authority receiver, @NotNull Topo topo, Date applicationDate, Document document, StandardEnvironmentalCommitments standardEnvironmentalCommitments, Opinion forestryOpinion, Opinion speleologyOpinion, Opinion archeologyOpinion, Opinion cityPlanningOpinion) {
        super(protocol, sender, receiver, topo, applicationDate, document);
        this.standardEnvironmentalCommitments = standardEnvironmentalCommitments;
        this.forestryOpinion = forestryOpinion;
        this.speleologyOpinion = speleologyOpinion;
        this.archeologyOpinion = archeologyOpinion;
        this.cityPlanningOpinion = cityPlanningOpinion;
    }

    public Opinion getForestryOpinion() {
        return forestryOpinion;
    }

    public void setForestryOpinion(Opinion forestryOpinion) {
        this.forestryOpinion = forestryOpinion;
    }

    public Opinion getSpeleologyOpinion() {
        return speleologyOpinion;
    }

    public void setSpeleologyOpinion(Opinion speleologyOpinion) {
        this.speleologyOpinion = speleologyOpinion;
    }

    public Opinion getArcheologyOpinion() {
        return archeologyOpinion;
    }

    public void setArcheologyOpinion(Opinion archeologyOpinion) {
        this.archeologyOpinion = archeologyOpinion;
    }

    public Opinion getCityPlanningOpinion() {
        return cityPlanningOpinion;
    }

    public void setCityPlanningOpinion(Opinion cityPlanningOpinion) {
        this.cityPlanningOpinion = cityPlanningOpinion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StandardEnvironmentalCommitmentsApplication)) return false;
        if (!super.equals(o)) return false;
        StandardEnvironmentalCommitmentsApplication that = (StandardEnvironmentalCommitmentsApplication) o;
        return Objects.equals(standardEnvironmentalCommitments, that.standardEnvironmentalCommitments) &&
                Objects.equals(forestryOpinion, that.forestryOpinion) &&
                Objects.equals(speleologyOpinion, that.speleologyOpinion) &&
                Objects.equals(archeologyOpinion, that.archeologyOpinion) &&
                Objects.equals(cityPlanningOpinion, that.cityPlanningOpinion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), standardEnvironmentalCommitments, forestryOpinion, speleologyOpinion, archeologyOpinion, cityPlanningOpinion);
    }

    @Override
    public String toString() {
        return "StandardEnvironmentalCommitmentsApplication{" +
                "standardEnvironmentalCommitments=" + standardEnvironmentalCommitments +
                ", forestryOpinion=" + forestryOpinion +
                ", speleologyOpinion=" + speleologyOpinion +
                ", archeologyOpinion=" + archeologyOpinion +
                ", cityPlanningOpinion=" + cityPlanningOpinion +
                "} " + super.toString();
    }
}

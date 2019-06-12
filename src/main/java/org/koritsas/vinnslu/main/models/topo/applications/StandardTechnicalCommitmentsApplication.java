package org.koritsas.vinnslu.main.models.topo.applications;


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

@Entity
public class StandardTechnicalCommitmentsApplication extends Application {

    @OneToOne
    private StandardTechnicalCommitments standardTechnicalCommitments;

    @ManyToOne
    @JoinColumn(name = "mining_overseeing_opinion_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "STC_MIN_FK"))
    private Opinion mineOverseeingOpinion;

    public StandardTechnicalCommitmentsApplication(String protocol, Company sender, Authority receiver, @NotNull Topo topo, Date applicationDate, Document document, StandardTechnicalCommitments standardTechnicalCommitments, Opinion mineOverseeingOpinion) {
        super(protocol, sender, receiver, topo, applicationDate, document);
        this.standardTechnicalCommitments = standardTechnicalCommitments;
        this.mineOverseeingOpinion = mineOverseeingOpinion;
    }

    public StandardTechnicalCommitments getStandardTechnicalCommitments() {
        return standardTechnicalCommitments;
    }

    public void setStandardTechnicalCommitments(StandardTechnicalCommitments standardTechnicalCommitments) {
        this.standardTechnicalCommitments = standardTechnicalCommitments;
    }

    public Opinion getMineOverseeingOpinion() {
        return mineOverseeingOpinion;
    }

    public void setMineOverseeingOpinion(Opinion mineOverseeingOpinion) {
        this.mineOverseeingOpinion = mineOverseeingOpinion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StandardTechnicalCommitmentsApplication)) return false;
        if (!super.equals(o)) return false;
        StandardTechnicalCommitmentsApplication that = (StandardTechnicalCommitmentsApplication) o;
        return Objects.equals(standardTechnicalCommitments, that.standardTechnicalCommitments) &&
                Objects.equals(mineOverseeingOpinion, that.mineOverseeingOpinion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), standardTechnicalCommitments, mineOverseeingOpinion);
    }

    @Override
    public String toString() {
        return "StandardTechnicalCommitmentsApplication{" +
                "standardTechnicalCommitments=" + standardTechnicalCommitments +
                ", mineOverseeingOpinion=" + mineOverseeingOpinion +
                "} " + super.toString();
    }
}

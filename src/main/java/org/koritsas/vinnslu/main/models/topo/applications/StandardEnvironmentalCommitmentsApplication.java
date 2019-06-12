package org.koritsas.vinnslu.main.models.topo.applications;

import org.koritsas.vinnslu.main.models.common.Authority;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.models.topo.StandardEnvironmentalCommitments;
import org.koritsas.vinnslu.main.models.topo.Topo;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class StandardEnvironmentalCommitmentsApplication extends Application {

    @ManyToOne
    @JoinColumn(name = "standard_environmental_commitments_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "SEC_APP_FK"))
    private StandardEnvironmentalCommitments standardEnvironmentalCommitments;

    public StandardEnvironmentalCommitmentsApplication(String protocol, Company sender, Authority receiver, @NotNull Topo topo, Document document, StandardEnvironmentalCommitments standardEnvironmentalCommitments) {
        super(protocol, sender, receiver, topo, document);
        this.standardEnvironmentalCommitments = standardEnvironmentalCommitments;
    }

    public StandardEnvironmentalCommitments getStandardEnvironmentalCommitments() {
        return standardEnvironmentalCommitments;
    }

    public void setStandardEnvironmentalCommitments(StandardEnvironmentalCommitments standardEnvironmentalCommitments) {
        this.standardEnvironmentalCommitments = standardEnvironmentalCommitments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StandardEnvironmentalCommitmentsApplication)) return false;
        if (!super.equals(o)) return false;
        StandardEnvironmentalCommitmentsApplication that = (StandardEnvironmentalCommitmentsApplication) o;
        return Objects.equals(standardEnvironmentalCommitments, that.standardEnvironmentalCommitments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), standardEnvironmentalCommitments);
    }

    @Override
    public String toString() {
        return "StandardEnvironmentalCommitmentsApplication{" +
                "standardEnvironmentalCommitments=" + standardEnvironmentalCommitments +
                "} " + super.toString();
    }
}

package org.koritsas.vinnslu.main.models.topo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import org.koritsas.vinnslu.main.models.common.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class EnvironmentalImpactStudy implements Serializable {
    @Id
    @GenericGenerator(
            name = "env_impact_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "env_impact_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "env_impact_generator")
    private Long id;

    private String ada;

    private String protocol;

    private boolean active;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "topo_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "ENV_IMPACT_TOPO_ID"))
    private Topo topo;

    @ManyToOne
    @JoinColumn(name = "env_impact_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "ENV_IMPACT_FK"))
    private Document document;

    public EnvironmentalImpactStudy() {
    }

    public EnvironmentalImpactStudy(String ada, String protocol, boolean active, Date startDate, Date endDate, Topo topo, Document document) {
        this.ada = ada;
        this.protocol = protocol;
        this.active = active;
        this.startDate = startDate;
        this.endDate = endDate;
        this.topo = topo;
        this.document = document;
    }

    public Long getId() {
        return id;
    }

    public String getAda() {
        return ada;
    }

    public void setAda(String ada) {
        this.ada = ada;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnvironmentalImpactStudy)) return false;
        EnvironmentalImpactStudy that = (EnvironmentalImpactStudy) o;
        return active == that.active &&
                Objects.equals(ada, that.ada) &&
                Objects.equals(protocol, that.protocol) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(topo, that.topo) &&
                Objects.equals(document, that.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ada, protocol, active, startDate, endDate, topo, document);
    }

    @Override
    public String toString() {
        return "EnvironmentalImpactStudy{" +
                "id=" + id +
                ", ada='" + ada + '\'' +
                ", protocol='" + protocol + '\'' +
                ", active=" + active +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", topo=" + topo +
                ", document=" + document +
                '}';
    }
}

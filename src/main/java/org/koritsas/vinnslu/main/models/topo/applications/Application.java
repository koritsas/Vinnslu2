package org.koritsas.vinnslu.main.models.topo.applications;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.koritsas.vinnslu.main.models.common.Authority;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.models.topo.Topo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
public class Application implements Serializable {

    @Id
    @GenericGenerator(
            name = "application_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "application_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "application_generator")
    private Long id;

    @Column(unique = true)
    private String protocol;

    @ManyToOne
    @JoinColumn(columnDefinition = "sender_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "SENDER_FK"))
    private Company sender;

    @ManyToOne
    @JoinColumn(columnDefinition = "receiver_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "RECEIVER_FK"))
    private Authority receiver;

    @NotNull
    @ManyToOne
    @JoinColumn(columnDefinition = "topo_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "APP_TOPO_FK"))
    private Topo topo;

    @Temporal(TemporalType.DATE)
    private Date applicationDate;

    @OneToOne(targetEntity = Document.class, fetch = FetchType.LAZY)
    private Document document;

    public Application() {
    }

    public Application(String protocol, Company sender, Authority receiver, @NotNull Topo topo, Date applicationDate, Document document) {
        this.protocol = protocol;
        this.sender = sender;
        this.receiver = receiver;
        this.topo = topo;
        this.applicationDate = applicationDate;
        this.document = document;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Company getSender() {
        return sender;
    }

    public void setSender(Company sender) {
        this.sender = sender;
    }

    public Authority getReceiver() {
        return receiver;
    }

    public void setReceiver(Authority receiver) {
        this.receiver = receiver;
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
        if (!(o instanceof Application)) return false;
        Application that = (Application) o;
        return Objects.equals(protocol, that.protocol) &&
                Objects.equals(sender, that.sender) &&
                Objects.equals(receiver, that.receiver) &&
                Objects.equals(topo, that.topo) &&
                Objects.equals(document, that.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(protocol, sender, receiver, topo, document);
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", protocol='" + protocol + '\'' +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", topo=" + topo +
                ", document=" + document +
                '}';
    }
}

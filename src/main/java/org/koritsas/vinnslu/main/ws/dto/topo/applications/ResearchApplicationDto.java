package org.koritsas.vinnslu.main.ws.dto.topo.applications;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.koritsas.vinnslu.main.models.common.Authority;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.models.common.Opinion;
import org.koritsas.vinnslu.main.models.topo.ResearchLicense;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.models.topo.applications.ResearchApplication;
import org.koritsas.vinnslu.main.utils.TopoDeserializer;
import org.koritsas.vinnslu.main.ws.dto.AbstractDto;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ResearchApplicationDto implements AbstractDto<Long> {

    private Long id;

    private String protocol;

    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "sender_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "RESEARCH_APP_SENDER_FK"))
    private Company sender;

    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "receiver_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "RESEARCH_APP_RECEIVER_FK"))
    private Authority receiver;

    @JsonDeserialize(using = TopoDeserializer.class)
    private Topo topo;

    private ResearchLicense researchLicense;

    private Opinion topographicalAuthorityOpinion;

    private Opinion geologicalInstituteOpinion;

    private Opinion armyOpinion;

    private Document document;


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

    public ResearchLicense getResearchLicense() {
        return researchLicense;
    }

    public void setResearchLicense(ResearchLicense researchLicense) {
        this.researchLicense = researchLicense;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public Long getId() {
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Class getClaZZ() {
        return ResearchApplication.class;
    }
}

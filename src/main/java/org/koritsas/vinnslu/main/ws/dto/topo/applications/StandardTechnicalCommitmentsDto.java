package org.koritsas.vinnslu.main.ws.dto.topo.applications;

import org.koritsas.vinnslu.main.models.common.Authority;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.models.common.Opinion;
import org.koritsas.vinnslu.main.models.topo.ResearchLicense;
import org.koritsas.vinnslu.main.models.topo.StandardTechnicalCommitments;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.ws.dto.AbstractDto;

public class StandardTechnicalCommitmentsDto implements AbstractDto<Long> {

    private Long id;


    private String protocol;

    private Company sender;

    private Authority receiver;

    private Topo topo;

    private ResearchLicense researchLicense;


    private Document document;

    private StandardTechnicalCommitments standardTechnicalCommitments;

    private Opinion mineOverseeingOpinion;

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
    public Long getId() {
        return id;
    }

    @Override
    public Class getClaZZ() {
        return StandardTechnicalCommitments.class;
    }
}

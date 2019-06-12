package org.koritsas.vinnslu.main.ws.dto.topo.applications;

import org.koritsas.vinnslu.main.models.common.Authority;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.common.Opinion;
import org.koritsas.vinnslu.main.models.topo.StandardEnvironmentalCommitments;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.ws.dto.AbstractDto;

public class StandardEnvironmentalCommitmentsApplicationDto implements AbstractDto<Long> {

    private Long id;


    private String protocol;

    private Company sender;

    private Authority receiver;

    private Topo topo;

    private StandardEnvironmentalCommitments standardEnvironmentalCommitments;

    private Opinion forestryOpinion;

    private Opinion speleologyOpinion;

    private Opinion archeologyOpinion;

    private Opinion cityPlanningOpinion;

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

    public StandardEnvironmentalCommitments getStandardEnvironmentalCommitments() {
        return standardEnvironmentalCommitments;
    }

    public void setStandardEnvironmentalCommitments(StandardEnvironmentalCommitments standardEnvironmentalCommitments) {
        this.standardEnvironmentalCommitments = standardEnvironmentalCommitments;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Class getClaZZ() {
        return StandardEnvironmentalCommitments.class;
    }
}

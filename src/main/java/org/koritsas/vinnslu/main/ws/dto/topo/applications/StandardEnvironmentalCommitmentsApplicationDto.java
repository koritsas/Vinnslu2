package org.koritsas.vinnslu.main.ws.dto.topo.applications;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.koritsas.vinnslu.main.models.common.Authority;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.models.common.Opinion;
import org.koritsas.vinnslu.main.models.topo.ResearchLicense;
import org.koritsas.vinnslu.main.models.topo.StandardEnvironmentalCommitments;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.models.topo.applications.ResearchApplication;
import org.koritsas.vinnslu.main.ws.dto.AbstractDto;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
public class StandardEnvironmentalCommitmentsApplicationDto implements AbstractDto<Long> {

    private Long id;


    private String protocol;


    private Company sender;


    private Authority receiver;



    private Date applicationDate;


    private Document document;

    private StandardEnvironmentalCommitments standardEnvironmentalCommitments;


    private Opinion forestryOpinion;


    private Opinion speleologyOpinion;


    private Opinion archeologyOpinion;


    private Opinion cityPlanningOpinion;


    private ResearchApplication researchApplication;

    @Override
    public Class getClaZZ() {
        return StandardEnvironmentalCommitments.class;
    }
}

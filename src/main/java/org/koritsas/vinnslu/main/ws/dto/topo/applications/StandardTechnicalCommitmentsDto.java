package org.koritsas.vinnslu.main.ws.dto.topo.applications;

import org.koritsas.vinnslu.main.models.common.Authority;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.common.Document;
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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Class getClaZZ() {
        return StandardTechnicalCommitments.class;
    }
}

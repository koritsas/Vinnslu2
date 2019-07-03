package org.koritsas.vinnslu.main.ws.dto.topo;

import lombok.Getter;
import lombok.Setter;
import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.models.common.Opinion;
import org.koritsas.vinnslu.main.models.topo.StandardTechnicalCommitments;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.models.topo.applications.StandardTechnicalCommitmentsApplication;
import org.koritsas.vinnslu.main.ws.dto.AbstractDto;
@Getter @Setter
public class StandardTechnicalCommitmentsDTO implements AbstractDto<Long> {

    private Long id;

    private String protocol;

    private String ada;

    private StandardTechnicalCommitmentsApplication standardTechnicalCommitmentsApplication;

    private Document document;


    @Override
    public Class getClaZZ() {
        return StandardTechnicalCommitments.class;
    }

}
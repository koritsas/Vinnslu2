package org.koritsas.vinnslu.main.ws.dto.topo.applications;

import lombok.Getter;
import org.koritsas.vinnslu.main.models.common.Authority;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.models.topo.EnvironmentalImpactStudy;
import org.koritsas.vinnslu.main.models.topo.applications.LeasingApplication;
import org.koritsas.vinnslu.main.ws.dto.AbstractDto;

import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.TemporalType;
import java.util.Date;
@Getter
public class LeasingApplicationDto implements AbstractDto<Long> {

    private Long id;

    private String protocol;

    private Company sender;

    private Date applicationDate;

    private Document document;

    private EnvironmentalImpactStudy environmentalImpactStudy;

    @Override
    public Class getClaZZ() {
        return LeasingApplication.class;
    }
}

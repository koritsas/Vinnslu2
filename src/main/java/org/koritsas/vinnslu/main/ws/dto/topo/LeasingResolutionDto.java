package org.koritsas.vinnslu.main.ws.dto.topo;

import lombok.Getter;
import org.hibernate.annotations.Cascade;
import org.koritsas.vinnslu.main.models.common.Authority;
import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.models.topo.LeasingResolution;
import org.koritsas.vinnslu.main.ws.dto.AbstractDto;
import org.springframework.context.annotation.Lazy;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
public class LeasingResolutionDto implements AbstractDto<Long> {

    private Long id;

    private String ada;

    private String protocol;

    private Authority sender;

    private Document document;

    @Override
    public Class getClaZZ() {
        return LeasingResolution.class;
    }
}

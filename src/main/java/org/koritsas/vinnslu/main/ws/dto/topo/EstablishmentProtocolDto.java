package org.koritsas.vinnslu.main.ws.dto.topo;

import lombok.Getter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.koritsas.vinnslu.main.models.common.Authority;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.topo.EstablishmentProtocol;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.ws.dto.AbstractDto;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Getter
public class EstablishmentProtocolDto implements AbstractDto<Long> {

    private Long id;

    private String protocol;


    private Company receiver;


    private Authority sender;


    private Topo topo;

    @Override
    public Class getClaZZ() {
        return EstablishmentProtocol.class;
    }
}

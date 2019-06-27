package org.koritsas.vinnslu.main.ws.dto.common;

import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.models.common.Opinion;
import org.koritsas.vinnslu.main.models.topo.EnvironmentalImpactStudy;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.ws.dto.AbstractDto;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class OpinionDTO implements AbstractDto<Long> {

    private Long id;

    @NotNull
    private boolean positive;

    private Document document;


    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPositive() {
        return positive;
    }

    public void setPositive(boolean positive) {
        this.positive = positive;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Class getClaZZ() {
        return Opinion.class;
    }


}

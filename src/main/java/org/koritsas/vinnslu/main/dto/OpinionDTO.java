package org.koritsas.vinnslu.main.dto;

import org.koritsas.vinnslu.main.models.common.Document;

public class OpinionDTO {

    private Long id;

    private boolean positive;

    private Document document;

    public Long getId() {
        return id;
    }

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
}

package org.koritsas.vinnslu.main.ws.dto.topo;

import org.koritsas.vinnslu.main.models.common.Authority;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.models.topo.Guarantee;
import org.koritsas.vinnslu.main.ws.dto.AbstractDto;

import javax.persistence.GenerationType;

public class GuaranteeDTO implements AbstractDto<Long> {

    private Long id;

    private GenerationType guaranteeType;

    private Authority authority;

    private Company company;

    private double amount;

    private Document document;

    public Long getId() {
        return id;
    }

    @Override
    public Class getClaZZ() {
        return Guarantee.class;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GenerationType getGuaranteeType() {
        return guaranteeType;
    }

    public void setGuaranteeType(GenerationType guaranteeType) {
        this.guaranteeType = guaranteeType;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}

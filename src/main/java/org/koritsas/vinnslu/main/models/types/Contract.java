package org.koritsas.vinnslu.main.models.types;

import lombok.Data;
import org.koritsas.vinnslu.main.models.common.Person;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Embeddable
public class Contract implements Serializable {


    private Long contractId;

    private String contractProtocol;

    @Temporal(TemporalType.DATE)
    private Date contractDate;

    @ManyToOne
    @JoinColumn(name = "notary_id", foreignKey = @ForeignKey(name = "PERSONS_ID_FK"))
    private Person notary;

    public Contract(Long contractId, Date contractDate, Person notary) {
        this.contractId = contractId;
        this.contractDate = contractDate;
        this.notary = notary;
    }

}

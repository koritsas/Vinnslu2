package org.koritsas.vinnslu.main.ws.dto.topo.applications;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.koritsas.vinnslu.main.models.common.Authority;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.models.common.Opinion;
import org.koritsas.vinnslu.main.models.topo.ResearchLicense;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.models.topo.applications.ResearchApplication;
import org.koritsas.vinnslu.main.utils.TopoDeserializer;
import org.koritsas.vinnslu.main.ws.dto.AbstractDto;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Getter @Setter
public class ResearchApplicationDto implements AbstractDto<Long> {

    private Long id;

    private String protocol;

    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "sender_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "RESEARCH_APP_SENDER_FK"))
    private Company sender;

    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "receiver_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "RESEARCH_APP_RECEIVER_FK"))
    private Authority receiver;

    @JsonDeserialize(using = TopoDeserializer.class)
    private Topo topo;

    private Date applicationDate;

    private ResearchLicense researchLicense;

    private Opinion topographicalAuthorityOpinion;

    private Opinion geologicalInstituteOpinion;

    private Opinion armyOpinion;

    private Document document;


    @Override
    public Class getClaZZ() {
        return ResearchApplication.class;
    }
}

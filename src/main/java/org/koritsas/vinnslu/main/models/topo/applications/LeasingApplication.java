package org.koritsas.vinnslu.main.models.topo.applications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.koritsas.vinnslu.main.models.topo.EnvironmentalImpactStudy;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class LeasingApplication extends Application{

    @OneToOne
    @JoinColumn(name = "environmental_impact_study_id",referencedColumnName="id",foreignKey = @ForeignKey(name = "ENV_STD_FK"))
    private EnvironmentalImpactStudy environmentalImpactStudy;
}

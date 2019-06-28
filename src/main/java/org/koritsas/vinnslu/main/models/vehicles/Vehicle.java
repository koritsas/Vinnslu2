package org.koritsas.vinnslu.main.models.vehicles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Parameter;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.common.Person;
import org.koritsas.vinnslu.main.models.types.Fuel;
import org.koritsas.vinnslu.main.models.types.VehicleType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Vehicle implements Serializable {

    @Id
    @GenericGenerator(
            name = "vehicle_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "vehicle_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "vehicle_generator")
    private Long id;

    @Column(precision = 17)
    @NaturalId
    private String frameNumber;

    @Column(precision = 6, unique = true)
    @NaturalId
    private String licensePlate;

    private String color;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @Enumerated(EnumType.STRING)
    private Fuel fuel;

    @Temporal(TemporalType.DATE)
    private Date exhaustCardEnd;

    @Temporal(TemporalType.DATE)
    private Date tollsEnd;

    @Temporal(TemporalType.DATE)
    private Date securityEnd;


    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.PERSIST})
    @JoinColumn(name = "owner_company", referencedColumnName = "id", foreignKey = @ForeignKey(name = "COMPANY_ID_FK"))
    private Company ownerCompany;

    @ManyToOne
    @JoinColumn(name = "driver", referencedColumnName = "id", foreignKey = @ForeignKey(name = "PERSON_ID_FK"))
    private Person driver;

    private String brand;

    private String model;


}

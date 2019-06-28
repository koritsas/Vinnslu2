package org.koritsas.vinnslu.main.models.vehicles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.types.Fuel;
import org.koritsas.vinnslu.main.models.types.MachineryType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Machine implements Serializable {

    @Id
    @GenericGenerator(
            name = "machine_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "machine_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "machine_generator")
    private Long id;

    @Enumerated(EnumType.STRING)
    private MachineryType category;

    private String brand;

    private String model;

    @Column(unique = true)
    private String stamp;

    @Column(unique = true)
    private String licensePlate;

    @Temporal(TemporalType.DATE)
    private Date licenseDate;

    private Long apad;

    private String ket;

    @Column(unique = true)
    private String frameNumber;

    @Column(unique = true)
    private String engineNumber;

    private int ps;

    private double kw;

    @Column(precision = 2)
    private double weight;

    @Column(precision = 2)
    private double length;

    @Column(precision = 2)
    private double width;

    @Column(precision = 2)
    private double height;

    @ManyToOne
    @JoinColumn(name = "company", referencedColumnName = "id", foreignKey = @ForeignKey(name = "COMPANY_FK"))
    private Company company;

    @Enumerated(EnumType.STRING)
    private Fuel fuel;

}

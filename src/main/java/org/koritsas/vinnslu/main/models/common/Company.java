package org.koritsas.vinnslu.main.models.common;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Company implements Serializable {

    @Id
    @GenericGenerator(
            name = "company_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "company_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "company_generator")
    private Long id;

    @NaturalId
    @Column(unique = true)
    private Long afm;

    @NotNull
    private String name;

    private String address;

    private Long phone;

    public Company() {
    }

    public Company(Long afm, @NotNull String name, String address, Long phone) {
        this.afm = afm;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }


}

package org.koritsas.vinnslu.main.models.common;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

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

    public Long getId() {
        return id;
    }

    public Long getAfm() {
        return afm;
    }

    public void setAfm(Long afm) {
        this.afm = afm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return afm.equals(company.afm) &&
                name.equals(company.name) &&
                address.equals(company.address) &&
                phone.equals(company.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(afm, name, address, phone);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", afm=" + afm +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                '}';
    }
}

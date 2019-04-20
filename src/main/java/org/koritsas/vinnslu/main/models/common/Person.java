package org.koritsas.vinnslu.main.models.common;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Person extends Company implements Serializable {

    private String surname;

    private String fathername;

    private Date birthDate;

    public Person(String surname, String fathername, Date birthDate) {
        this.surname = surname;
        this.fathername = fathername;
        this.birthDate = birthDate;
    }

    public Person(Long afm, @NotNull String name, String address, Long phone, String surname, String fathername, Date birthDate) {
        super(afm, name, address, phone);
        this.surname = surname;
        this.fathername = fathername;
        this.birthDate = birthDate;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        if (!super.equals(o)) return false;
        Person person = (Person) o;
        return Objects.equals(surname, person.surname) &&
                Objects.equals(fathername, person.fathername) &&
                Objects.equals(birthDate, person.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), surname, fathername, birthDate);
    }

    @Override
    public String toString() {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", fathername='" + fathername + '\'' +
                ", birthDate=" + birthDate +
                ", id=" + getId() +
                ", afm=" + getAfm() +
                ", name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", phone=" + getPhone() +
                "} ";
    }

}

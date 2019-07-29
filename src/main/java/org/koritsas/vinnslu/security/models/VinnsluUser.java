package org.koritsas.vinnslu.security.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.UniqueElements;
import org.koritsas.vinnslu.security.annotations.ValidEmail;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;



@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter @Setter
//@ToString(callSuper = true)
public class VinnsluUser implements Serializable {

    @Id
    @GenericGenerator(
            name = "user_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "user_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "user_generator")
    private Long id;

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    @ValidEmail
    @Column(unique = true)
    private String email;

    private boolean enabled;

    private boolean tokenExpired;

    @Temporal(TemporalType.DATE)
    private final Date registrationDate = new Date();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id",foreignKey = @ForeignKey(name = "USR_ROLE_FK")),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id",foreignKey = @ForeignKey(name = "ROLE_USR_FK")))
    private Collection<Role> roles;


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VinnsluUser{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", enabled=").append(enabled);
        sb.append(", tokenExpired=").append(tokenExpired);
        sb.append(", registrationDate=").append(registrationDate);
        sb.append(", roles=").append(roles);
        sb.append('}');
        return sb.toString();
    }
}

package org.koritsas.vinnslu.security.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

    @Id
    @GenericGenerator(
            name = "role_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "role_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "role_generator")
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;


    @ManyToMany
    @JoinTable(name = "role_privileges",
    joinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "privilege_id",referencedColumnName = "id")
    )
    private Collection<Privilege> privileges;

    public Role(String name) {
        this.name = name;
    }
}

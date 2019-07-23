package org.koritsas.vinnslu.security.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class Privilege implements Serializable {

    @Id
    @GenericGenerator(
            name = "privilege_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "privilege_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "privilege_generator")
    private Long id;

    @Column(unique = true)
    private String name;



    @ManyToMany(mappedBy = "privileges",fetch = FetchType.EAGER)
    private Collection<Role> roles;


    public Privilege(String name) {
        this.name = name;
    }
}

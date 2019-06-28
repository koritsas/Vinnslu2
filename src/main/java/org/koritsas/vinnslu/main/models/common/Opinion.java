package org.koritsas.vinnslu.main.models.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Opinion implements Serializable {

    @Id
    @GenericGenerator(
            name = "opinions_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "opinions_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }

    )
    @GeneratedValue(generator = "opinions_generator")
    private Long id;

    @NotNull
    private boolean positive;

    private Document document;

}

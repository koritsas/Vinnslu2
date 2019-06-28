package org.koritsas.vinnslu.main.models.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Document implements Serializable {

    @Id
    @GenericGenerator(
            name = "document_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "document_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "document_generator")
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "SENDER_ID_FK"))
    private Company sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "RECEIVER_ID_FK"))
    private Company receiver;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String protocol;

    private String mimetype;

    @Lob
    @Column(unique = true)
    private File file;


}

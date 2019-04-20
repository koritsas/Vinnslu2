package org.koritsas.vinnslu.main.models.common;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

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

    public Opinion() {
    }

    public Opinion(boolean positive, Document document) {
        this.positive = positive;
        this.document = document;
    }

    public boolean isPositive() {
        return positive;
    }

    public Long getId() {
        return id;
    }

    public void setPositive(boolean positive) {
        this.positive = positive;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Opinion)) return false;
        Opinion opinion = (Opinion) o;
        return positive == opinion.positive &&
                Objects.equals(document, opinion.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positive, document);
    }

    @Override
    public String toString() {
        return "Opinion{" +
                "id=" + id +
                ", positive=" + positive +
                ", document=" + document +
                '}';
    }
}

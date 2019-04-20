package org.koritsas.vinnslu.main.models.common;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

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

    public Document() {
    }

    public Document(String name, Company sender, Company receiver, Date date, String protocol, String mimetype, File file) {
        this.name = name;
        this.sender = sender;
        this.receiver = receiver;
        this.date = date;
        this.protocol = protocol;
        this.mimetype = mimetype;
        this.file = file;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getSender() {
        return sender;
    }

    public void setSender(Company sender) {
        this.sender = sender;
    }

    public Company getReceiver() {
        return receiver;
    }

    public void setReceiver(Company receiver) {
        this.receiver = receiver;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(name, document.name) &&
                Objects.equals(sender, document.sender) &&
                Objects.equals(receiver, document.receiver) &&
                Objects.equals(date, document.date) &&
                Objects.equals(protocol, document.protocol) &&
                Objects.equals(mimetype, document.mimetype) &&
                Objects.equals(file, document.file);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sender, receiver, date, protocol, mimetype, file);
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", date=" + date +
                ", protocol='" + protocol + '\'' +
                ", mimetype='" + mimetype + '\'' +
                ", file=" + file +
                '}';
    }
}

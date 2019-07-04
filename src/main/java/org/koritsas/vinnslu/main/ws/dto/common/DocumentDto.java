package org.koritsas.vinnslu.main.ws.dto.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.ws.dto.AbstractDto;

import java.io.File;
import java.util.Date;
@Getter @Setter
public class DocumentDto implements AbstractDto<Long> {

    private Long id;


    private String name;


    private Company sender;


    private Company receiver;


    private Date date;

    private String protocol;

    @JsonIgnore
    private String fileName;

    @JsonIgnore
    private String fileType;

    @JsonIgnore
    private byte[] data;

    @Override
    public Class getClaZZ() {
        return Document.class;
    }
}

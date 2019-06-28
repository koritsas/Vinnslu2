package org.koritsas.vinnslu.main.models.common;

import lombok.Data;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
public class Authority extends Company implements Serializable {

    public Authority() {
    }

    public Authority(Long afm, @NotNull String name, String address, Long phone) {
        super(afm, name, address, phone);
    }


}

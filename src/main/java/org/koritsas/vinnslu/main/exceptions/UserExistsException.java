package org.koritsas.vinnslu.main.exceptions;

import org.koritsas.vinnslu.security.models.VinnsluUser;

public class UserExistsException extends RuntimeException {

    private VinnsluUser vinnsluUser;

    public UserExistsException(VinnsluUser vinnsluUser){
            this.vinnsluUser = vinnsluUser;
    }

    public VinnsluUser getVinnsluUser(){
        return this.vinnsluUser;
    }
}

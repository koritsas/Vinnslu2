package org.koritsas.vinnslu.main.exceptions;

import org.koritsas.vinnslu.security.models.User;

public class UserExistsException extends RuntimeException {

    private User user;

    public UserExistsException(User user){
            this.user=user;
    }

    public User getUser(){
        return this.user;
    }
}

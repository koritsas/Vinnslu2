package org.koritsas.vinnslu.security.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.koritsas.vinnslu.security.annotations.PasswordMatches;
import org.koritsas.vinnslu.security.annotations.ValidEmail;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
@ToString
@PasswordMatches
public class UserDto {

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;

    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;
}

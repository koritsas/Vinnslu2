package org.koritsas.vinnslu.security.validators;



import org.koritsas.vinnslu.security.annotations.PasswordMatches;
import org.koritsas.vinnslu.security.dtos.VinnsluUserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        VinnsluUserDto user = (VinnsluUserDto) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
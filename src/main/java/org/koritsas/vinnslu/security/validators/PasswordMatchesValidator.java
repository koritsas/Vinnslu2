package org.koritsas.vinnslu.security.validators;



import org.koritsas.vinnslu.security.annotations.PasswordMatches;
import org.koritsas.vinnslu.security.dtos.VinnsluUserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches,Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        VinnsluUserDto dto = (VinnsluUserDto) value;

        return dto.getPassword().equals(((VinnsluUserDto) value).getMatchingPassword());
    }
}

package javabuoi3.minhlong.Validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import javabuoi3.minhlong.Validator.annotation.ValidUserId;
import javabuoi3.minhlong.entity.User;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User> {
    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {
        if(user == null) return true;
        return user.getId() != null;
    }
}

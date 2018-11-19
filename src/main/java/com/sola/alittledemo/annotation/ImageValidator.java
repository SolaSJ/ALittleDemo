package com.sola.alittledemo.annotation;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Sola
 * @date 2018/10/24
 */
@Component
public class ImageValidator implements ConstraintValidator<Image, String> {

    private String message;

    @Override
    public void initialize(Image constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return true;
        }

        boolean isValid = s.endsWith(".jpg");

        return isValid;
    }
}
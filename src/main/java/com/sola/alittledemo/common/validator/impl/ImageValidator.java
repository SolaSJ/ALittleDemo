package com.sola.alittledemo.common.validator.impl;

import com.sola.alittledemo.common.validator.AbstractImageValidator;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidatorContext;

/**
 * @author Sola
 * @date 2018/10/24
 */
@Component
public class ImageValidator extends AbstractImageValidator<String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return true;
        }
        return s.endsWith(".jpg");
    }

}
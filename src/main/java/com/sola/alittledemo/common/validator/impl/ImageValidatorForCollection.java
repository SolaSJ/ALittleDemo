package com.sola.alittledemo.common.validator.impl;

import com.sola.alittledemo.common.validator.AbstractImageValidator;

import javax.validation.ConstraintValidatorContext;
import java.util.Collection;

/**
 * @author Sola
 * @date 2018/11/23
 */
public class ImageValidatorForCollection extends AbstractImageValidator<Collection> {

    @Override
    public boolean isValid(Collection collection, ConstraintValidatorContext constraintValidatorContext) {
        if (collection == null) {
            return true;
        }
        for (Object o : collection) {
            if (o instanceof String) {
                if (!((String) o).endsWith(".jpg")) {
                    return false;
                }
            }
        }
        return true;
    }

}

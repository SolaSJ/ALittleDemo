package com.sola.alittledemo.common.annotation;

import com.sola.alittledemo.common.validator.impl.ImageValidator;
import com.sola.alittledemo.common.validator.impl.ImageValidatorForCollection;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Sola
 * @date 2018/10/24
 */
@Documented
@Constraint(
        validatedBy = {ImageValidator.class, ImageValidatorForCollection.class}
)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Image {

    String message() default "{javax.validation.constraints.NotBlank.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

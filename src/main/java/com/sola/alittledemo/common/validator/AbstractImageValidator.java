package com.sola.alittledemo.common.validator;

import com.sola.alittledemo.common.annotation.Image;

import javax.validation.ConstraintValidator;

/**
 * @author Sola
 * @date 2018/11/23
 */
public abstract class AbstractImageValidator<T> implements ConstraintValidator<Image, T> {
}

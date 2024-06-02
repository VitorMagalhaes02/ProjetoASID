package com.iStudent.microservicos.studentmark.model.validation;



import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ValidEGNValidator.class)
public @interface ValidEGN {

    String message() default "Invalid EGN";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

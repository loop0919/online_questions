package jp.te4a.spring.boot.online_questions.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = AnswerValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidAnswer {
    String message() default "Invalid answer";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

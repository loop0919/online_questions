package jp.te4a.spring.boot.online_questions.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AnswerValidator implements ConstraintValidator<ValidAnswer, String> {

    @Override
    public void initialize(ValidAnswer constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false; // 空文字またはnullは無効
        }
        try {
            int intValue = Integer.parseInt(value);
            return intValue >= 0 && intValue <= 1_000_000_000; // 指定範囲内の整数かをチェック
        } catch (NumberFormatException e) {
            return false; // 数字でない場合は無効
        }
    }
}

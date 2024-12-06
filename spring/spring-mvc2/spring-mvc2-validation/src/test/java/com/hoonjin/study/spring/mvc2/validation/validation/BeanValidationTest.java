package com.hoonjin.study.spring.mvc2.validation.validation;

import com.hoonjin.study.spring.mvc2.validation.domain.Item;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

public class BeanValidationTest {

    @Test
    void beanValidation() {
        try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
            Validator validator = validatorFactory.getValidator();

            Item item = new Item();
            item.setItemName(" "); // 공백일 수 없습니다
            item.setPrice(999); // 1000에서 10000000 사이여야 합니다
            item.setQuantity(10000); // 9999 이하여야 합니다

            validator.validate(item).forEach(itemConstraintViolation -> {
                System.out.println("itemConstraintViolation = " + itemConstraintViolation);
                System.out.println("itemConstraintViolation.getMessage() = " + itemConstraintViolation.getMessage());
            });
        }
    }
}

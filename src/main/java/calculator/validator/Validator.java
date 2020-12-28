package calculator.validator;

import java.util.Arrays;

public class Validator {
    private String value;
    private String[] values;

    public Validator(String value) {
        this.value = value;
        this.values = value.split(" ");
    }

    public boolean validateAll() {
        values = value.split(" ");
        if (!validateLength()) {
            throw new IllegalArgumentException("(예외)정확한 입력 값의 갯수가 아닙니다.");
        }
        if (!validateForm()) {
            throw new IllegalArgumentException("(예외)정확한 입력 값의 형태가 아닙니다.");
        }
        if (!dividedZero()) {
            throw new IllegalArgumentException("(예외)0으로 값을 나눌 수 없습니다.");
        }
        if(!validateOrderOfNumbers() || !validateOrderOfOperator()) {
            throw new IllegalArgumentException("(예외)정확한 입력 값의 순서 혹은 올바른 연산자가 아닙니다.");
        }
        return true;
    }

    private boolean validateLength() {
        return values.length == 3;
    }

    private boolean validateForm() {
        return !(Arrays.stream(values).anyMatch(x -> !isNumeric(x) && !(x.matches("[+|\\-|*|/]"))));
    }

    private boolean dividedZero() {
        return !(value.contains("/ 0"));
    }

    private boolean validateOrderOfNumbers() {
        int wrongCount = 0;
        for (int i = 0; i < values.length; i += 2)
            wrongCount += (isNumeric(values[i])) ? 0 : 1;
        return wrongCount <= 0;
    }

    private boolean validateOrderOfOperator() {
        int wrongCount = 0;
        for (int i = 1; i < values.length; i += 2)
            wrongCount += (values[i].matches("[+|\\-|*|/]")) ? 0 : 1;
        return wrongCount <= 0;
    }

    private boolean isNumeric(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
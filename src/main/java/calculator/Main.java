package calculator;

import java.util.Scanner;

import calculator.domain.Calculator;
import calculator.validator.Validator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isValid;
        String value;

        do {
            System.out.println("계산식을 입력해주세요.");
            value = scanner.nextLine();
            isValid = operate(value);
        } while (!isValid);

        Calculator calculator = new Calculator(value.split(" "));
        System.out.println(calculator.calculate());
    }

    private static boolean operate(String value) {
        try {
            return new Validator(value).validateAll();
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return false;
        }
    }
}

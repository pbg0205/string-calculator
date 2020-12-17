package calculator.domain;

public class Calculator {
    private String[] values;

    public Calculator(String[] values) {
        this.values = values;
    }

    public double calculate() {
        double num1 = Double.parseDouble(values[0]);
        String operator = values[1];
        double num2 = Double.parseDouble(values[2]);

        return Operator.calculate(num1,operator, num2);//TODO return 값 변경
    }
}
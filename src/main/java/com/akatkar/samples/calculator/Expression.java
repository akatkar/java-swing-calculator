package com.akatkar.samples.calculator;

class Expression {

    private double operand;
    private int operandCount = 0;

    private Operator operator = null;

    double calculate(Operator newOperator, double newOperand) {

        if (newOperator == Operator.EQUAL) {
            operand = this.operator.apply(operand, newOperand);
            operandCount = 0;
        } else {
            operandCount++;
            operand = operandCount > 1 ? this.operator.apply(operand, newOperand)
                    : newOperand;
            this.operator = newOperator;
        }
        return operand;
    }

    double calculate(Operator newOperator) {
        return calculate(newOperator, operand);
    }

    void clear(){
        operand = 0.0;
        operandCount = 0;
        operator = null;
    }
}

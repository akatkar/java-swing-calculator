package com.akatkar.samples.calculator;

import java.util.Optional;

class Expression {

    private double operand;
    private int operandCount;
    private Operator operator = null;

    private double calculate(Operator newOperator, double newOperand) {

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

    double calculate(Operator newOperator, Optional<Double> newOperand) {
        return newOperand
                .map(op -> calculate(newOperator, op))
                .orElseGet(() -> calculate(newOperator, operand));
    }

    void clear(){
        operand = 0.0;
        operandCount = 0;
        operator = null;
    }
}

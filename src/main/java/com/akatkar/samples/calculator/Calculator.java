package com.akatkar.samples.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public final class Calculator extends JFrame implements ActionListener {

    private double operand1;
    private int operandCount = 0;
    private Operator previousOperator = null;
    private Display display;

    private enum Operator {

        EQUAL, PLUS, MINUS, MULTIPLY, DIVIDE;
    }

    public Calculator() {
        super("Calculator");
        initComponents();
        setSize(230, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        display = new Display();
        panel.add(display);

        panel.add(new Keypad(this));
        this.add(panel);
    }

    private void clearDisplay() {
        display.clear();
    }

    private void pressedNumber(String number) {
        if (this.previousOperator == Operator.EQUAL) {
            previousOperator = null;
            clearDisplay();
            display.clearDot();
        }

        display.append(number);
    }

    private void pressedClear() {
        previousOperator = null;
        operand1 = 0;
        clearDisplay();
        operandCount = 0;
    }

    private void calculate(Operator operator, double b) {
        switch (operator) {
            case PLUS:
                operand1 += b;
                break;
            case MINUS:
                operand1 -= b;
                break;
            case MULTIPLY:
                operand1 *= b;
                break;
            case DIVIDE:
                operand1 /= b;
                break;
        }
    }

    private void pressedOperator(Operator operator) {

        double operand2 = display.hasValue() ? display.getValue() : operand1;

        if (operator == Operator.EQUAL) {

            calculate(previousOperator, operand2);
            operandCount = 0;

        } else {
            operandCount++;
            if (operandCount > 1) {
                calculate(operator, operand2);
            }else{
                operand1 = operand2;
            }
            clearDisplay();
        }
        display.setValue(operand1);
        previousOperator = operator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton src = (JButton) e.getSource();
        switch (src.getText()) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                pressedNumber(src.getText());
                break;

            case "=":
                pressedOperator(Operator.EQUAL);
                break;
            case "+":
                pressedOperator(Operator.PLUS);
                break;
            case "-":
                pressedOperator(Operator.MINUS);
                break;
            case "x":
                pressedOperator(Operator.MULTIPLY);
                break;
            case "/":
                pressedOperator(Operator.DIVIDE);
                break;
            case ".":
                display.dotPressed();
                break;
            case "C":
                pressedClear();
                break;
        }
    }
}

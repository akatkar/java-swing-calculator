package com.akatkar.samples.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public final class Calculator extends JFrame implements ActionListener {

    private static final Pattern DIGIT = Pattern.compile("[\\d]+");
    private static final Pattern OPERATORS = Pattern.compile("[-+x\\/=]");

    private double operand1;
    private int operandCount = 0;
    private Operator previousOperator = null;
    private Display display;

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
        }

        display.append(number);
    }

    private void pressedClear() {
        previousOperator = null;
        operand1 = 0;
        clearDisplay();
        operandCount = 0;
    }

    private void pressedOperator(Operator operator) {

        double operand2 = display.hasValue() ? display.getValue() : operand1;

        if (operator == Operator.EQUAL) {
            operand1 = previousOperator.apply(operand1, operand2);
            operandCount = 0;

        } else {
            operandCount++;
            operand1 = operandCount > 1 ? operator.apply(operand1, operand2):operand2;
            clearDisplay();
        }
        display.setValue(operand1);
        previousOperator = operator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton src = (JButton) e.getSource();
        String token = src.getText();
        if (DIGIT.matcher(token).matches()) {
            pressedNumber(token);
        } else if (OPERATORS.matcher(token).matches()) {
            pressedOperator(Operator.fromString(token).get());
        } else if ("C".equals(token)) {
            pressedClear();
        } else if (".".equals(token)){
            display.dotPressed();
        }
    }
}

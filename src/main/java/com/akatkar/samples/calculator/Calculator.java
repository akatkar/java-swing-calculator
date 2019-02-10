package com.akatkar.samples.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculator extends JFrame implements ActionListener {

    private double operand1;
    private double displayValue;
    private Operator operator = null;
    private Display display;

    enum Operator {

        EQUAL, PLUS, MINUS, MULTIPLY, DIVIDE;
    }

    public Calculator() {
        super("Calculator");
        initComponents();
        setSize(230, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        display = new Display();
        panel.add(display);

        panel.add(new Keypad(this));
        this.add(panel);
    }

    private void pressedNumber(int number) {
        if (this.operator == Operator.EQUAL) {
            operator = null;
            displayValue = 0;
        }

        if (displayValue == 0 && number == 0) {
            return;
        }

        displayValue = displayValue * 10 + number;
        display.setValue("" + displayValue);
    }
    
    private void pressedClear() {
        displayValue = 0;
        operator = null;
        operand1 = 0;
        display.setValue("" + displayValue);
    }

    private void pressedOperator(Operator operator) {
        if (operator == Operator.EQUAL) {
            switch (this.operator) {
                case PLUS:
                    displayValue = operand1 + displayValue;
                    break;
                case MINUS:
                    displayValue = operand1 - displayValue;
                    break;
                case MULTIPLY:
                    displayValue = operand1 * displayValue;
                    break;
                case DIVIDE:
                    displayValue = operand1 / displayValue;
                    break;
            }
            this.operator = operator;
        } else {
            this.operator = operator;
            operand1 = displayValue;
            displayValue = 0;
        }

        display.setValue("" + displayValue);
    }

    @Override  
    public void actionPerformed(ActionEvent e) {

        JButton src = (JButton) e.getSource();
        switch (src.getText()) {
            case "0":
                pressedNumber(0);
                break;
            case "1":
                pressedNumber(1);
                break;
            case "2":
                pressedNumber(2);
                break;
            case "3":
                pressedNumber(3);
                break;
            case "4":
                pressedNumber(4);
                break;
            case "5":
                pressedNumber(5);
                break;
            case "6":
                pressedNumber(6);
                break;
            case "7":
                pressedNumber(7);
                break;
            case "8":
                pressedNumber(8);
                break;
            case "9":
                pressedNumber(9);
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
            case "C":
                pressedClear();
                break;

        }
    }
}

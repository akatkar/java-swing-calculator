package com.akatkar.samples.calculator;

import java.awt.GridLayout;
import java.util.Optional;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Display extends JPanel {

    private JTextField display;
    private final StringBuilder displayValue;

    Display() {
        initComponents();
        displayValue = new StringBuilder(32);
    }

    private void initComponents() {
        this.setLayout(new GridLayout(1, 1));

        display = new JTextField("0");
        display.setHorizontalAlignment(JTextField.RIGHT);
        this.add(display);
    }

    private boolean hasFraction(double value) {
        return Math.round(value) != value;
    }

    void setValue(double value) {
        display.setText(hasFraction(value)
                ? Double.toString(value)
                : Long.toString((long) value));
    }

    Optional<Double> getValue() {
        if(hasValue()){
            double value = Double.parseDouble(displayValue.toString());
            this.clear();
            return Optional.of(value);
        }
        return Optional.empty();
    }

    void append(String number) {
        displayValue.append(number);
        display.setText(displayValue.toString());
    }

    private boolean hasValue() {
        return displayValue.length() > 0;
    }

    void clear() {
        displayValue.delete(0, displayValue.length());
        display.setText("0");
    }

    void dotPressed() {
        if (displayValue.indexOf(".") == -1)
            displayValue.append('.');
    }
}
